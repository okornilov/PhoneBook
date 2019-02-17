package ru.company.services.web.beans;

import lombok.Data;
import ru.company.services.personws.*;
import ru.company.services.web.Action;
import ru.company.services.web.SessionUtils;
import ru.company.services.web.UserAction;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;

@ManagedBean
@RequestScoped
@Data
public class UserListBean {

    private List<TUser> personList;
    private Integer totalCount;
    private UserServiceImpl userServiceImplPort;
    private String searchText;


    @PostConstruct
    public void init(){
        UserServiceImplService serviceImplService = new UserServiceImplService();
        userServiceImplPort = serviceImplService.getUserServiceImplPort();
        find();
    }

    @PreDestroy
    public void destroy(){
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public String edit(TUser user){
        SessionUtils.getHttpSession().setAttribute("userAction",new UserAction(Action.EDIT, user));
        return "useritem";
    }

    public String delete(TUser user){
        SessionUtils.getHttpSession().setAttribute("userAction",new UserAction(Action.DELETE, user));
        return "useritem";
    }

    public String add(){
        SessionUtils.getHttpSession().removeAttribute("userAction");
        return "useritem";
    }

    public String find(){
        TUserListRequest req = new TUserListRequest();
        req.setSearchText(searchText);
        TUserListResponse tUserListResponse = userServiceImplPort.userGetList(req);
        totalCount = tUserListResponse.getTotalCount();
        personList = tUserListResponse.getUser();
        return "userlist";
    }

    public String clear(){
        this.searchText = null;
        return "userlist";
    }


}
