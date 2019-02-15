package ru.company.services.web.beans;

import lombok.Data;
import ru.company.services.personws.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@RequestScoped
@Data
public class UserListBean {

    private List<TUser> personList;
    private Integer totalCount;
    private UserServiceImpl userServiceImplPort;


    @PostConstruct
    public void init(){
        UserServiceImplService serviceImplService = new UserServiceImplService();
        UserServiceImpl userServiceImplPort = serviceImplService.getUserServiceImplPort();
        TUserListResponse tUserListResponse = userServiceImplPort.userGetList(new TUser());
        totalCount = tUserListResponse.getTotalCount();
        personList = tUserListResponse.getUser();
    }

    @PreDestroy
    public void destroy(){
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public String delete(TUser user){
        System.out.println(user);
        TUserDeleteRequest req = new TUserDeleteRequest();
        req.setUserId(user.getId());
        userServiceImplPort.userDelete(req);
        return "/userlist.xhtml?faces-redirect=true";
    }

    public String add(){
        return "useritem";
    }

}
