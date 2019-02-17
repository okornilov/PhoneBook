package ru.company.services.web.beans;

import lombok.Data;
import org.apache.commons.codec.binary.Base64;
import ru.company.services.personws.*;
import ru.company.services.web.Action;
import ru.company.services.web.SessionUtils;
import ru.company.services.web.UserAction;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@ManagedBean
@RequestScoped
@Data
public class UserDetailBean {

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
    private Part uploadedFile;
    private Action action = Action.ADD;

    private UserServiceImpl userServiceImplPort;

    public String doAction(){
        switch (action){
            case ADD: {
                TUserCreateRequest req = new TUserCreateRequest();
                req.setLogin(login);
                req.setPassword(password);
                req.setFirstName(firstName);
                req.setLastName(lastName);
                req.setMiddleName(middleName);
                req.setPhoneCode(phoneCode);
                req.setPhoneNumber(phoneNumber);

                if (uploadedFile != null){
                    req.setImage(getFileBase64String());
                }

                userServiceImplPort.userCreate(req);
                break;
            }
            case EDIT:{
                TUserUpdateRequest req = new TUserUpdateRequest();
                req.setUserId(id);
                req.setLogin(login);
                req.setPassword(password);
                req.setFirstName(firstName);
                req.setLastName(lastName);
                req.setMiddleName(middleName);
                req.setPhoneCode(phoneCode);
                req.setPhoneNumber(phoneNumber);

                if (uploadedFile != null){
                    req.setImage(getFileBase64String());
                }

                userServiceImplPort.userUpdate(req);
                break;
            } case DELETE:{
                TUserDeleteRequest req = new TUserDeleteRequest();
                req.setUserId(id);
                userServiceImplPort.userDelete(req);
            }
        }
        return "userlist.xhtml?faces-redirect=true";
    }

    public Boolean isDeleteAction(){
        return action == Action.DELETE;
    }

    public Boolean isUpdateAction(){
        return action == Action.EDIT;
    }

    @PostConstruct
    public void init(){
        UserServiceImplService userServiceImplService = new UserServiceImplService();
        userServiceImplPort = userServiceImplService.getUserServiceImplPort();

        TUser user = null;
        UserAction userAction = (UserAction) SessionUtils.getHttpSession().getAttribute("userAction");

        if (userAction != null){
            action = userAction.getAction();
            user = userAction.getUser();
        }

        if (user != null){
            this.id = user.getId();
            this.login = user.getLogin();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.middleName = user.getMiddleName();
            this.phoneCode = user.getPhoneCode();
            this.phoneNumber = user.getPhoneNumber();
        }
    }

    private String getFileBase64String(){
        try (InputStream input = uploadedFile.getInputStream()) {
            byte[] bArray = new byte[input.available()];
            input.read(bArray);
            return Base64.encodeBase64String(bArray);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
