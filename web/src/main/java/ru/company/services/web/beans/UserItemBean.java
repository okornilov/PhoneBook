package ru.company.services.web.beans;

import lombok.Data;
import ru.company.services.personws.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;

@ManagedBean
@RequestScoped
@Data
public class UserItemBean {

    private Long id;
    private String login;
    private String password;
    private String passwordConfirm;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String email;
    private String phoneCode;
    private String phoneNumber;
    private String actionName;

    private UserServiceImpl userServiceImplPort;

    public UserItemBean() {
        this.actionName = "Save";
    }

    public String doAction(){
        TUserCreateRequest tUserCreateRequest = new TUserCreateRequest();
        tUserCreateRequest.setLogin(login);
        tUserCreateRequest.setPassword(password);
        tUserCreateRequest.setFirstName(firstName);
        tUserCreateRequest.setLastName(lastName);
        tUserCreateRequest.setMiddleName(middleName);
        tUserCreateRequest.setPhoneCode(phoneCode);
        tUserCreateRequest.setPhoneNumber(phoneNumber);

        System.out.println(this.toString());

        userServiceImplPort.userCreate(tUserCreateRequest);
        return "userlist.xhtml?faces-redirect=true";
    }

    @PostConstruct
    public void init(){
        UserServiceImplService userServiceImplService = new UserServiceImplService();
        userServiceImplPort = userServiceImplService.getUserServiceImplPort();


        if (id != null){
            TUser req = new TUser();
            req.setId(id);
            TUserListResponse tUserListResponse = userServiceImplPort.userGetList(req);
            List<TUser> userList = tUserListResponse.getUser();

            if (userList != null && userList.size() > 0){
                TUser user = userList.get(0);
                this.login = user.getLogin();
                this.firstName = user.getFirstName();
                this.lastName = user.getLastName();
                this.middleName = user.getMiddleName();
                this.phoneCode = user.getPhoneCode();
                this.phoneNumber = user.getPhoneNumber();
            }
        }
    }
}
