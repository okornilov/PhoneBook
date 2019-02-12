package ru.company.services.web.beans;

import lombok.Data;
import ru.company.services.personws.TUserCreateRequest;
import ru.company.services.personws.UserServiceImpl;
import ru.company.services.personws.UserServiceImplService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

@ManagedBean
@RequestScoped
@Data
public class UserItemBean {

    private String login;
    private String password;
    private String passwordConfirm;
    private Date birthDate;
    private String email;
    private String phoneCode;
    private String phoneNumber;
    private String actionName;

    public UserItemBean() {
        this.actionName = "Save";
    }

    public String doAction(){
        UserServiceImplService userServiceImplService = new UserServiceImplService();
        UserServiceImpl userServiceImplPort = userServiceImplService.getUserServiceImplPort();
        TUserCreateRequest tUserCreateRequest = new TUserCreateRequest();
        tUserCreateRequest.setLogin(login);
        tUserCreateRequest.setPassword(password);
        userServiceImplPort.userCreate(tUserCreateRequest);
        return "userlist.xhtml?faces-redirect=true";
    }
}
