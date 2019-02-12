package ru.company.services.web.beans;

import lombok.Data;
import ru.company.services.personws.AuthServiceImpl;
import ru.company.services.personws.AuthServiceImplService;
import ru.company.services.personws.TAuthRequest;
import ru.company.services.personws.TAuthResponse;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@ManagedBean
@RequestScoped
@Data
public class LoginBean {

    @NotNull
    private String login;
    private String password;
    private String loginMessage;

    public String doLogin(){

        AuthServiceImplService authServiceImplService = new AuthServiceImplService();
        AuthServiceImpl authServiceImplPort = authServiceImplService.getAuthServiceImplPort();
        TAuthRequest tAuthRequest = new TAuthRequest();
        tAuthRequest.setLogin(getLogin());
        tAuthRequest.setPassword(getPassword());

        TAuthResponse authResponse = authServiceImplPort.auth(tAuthRequest);
        ru.company.services.personws.TResponseStatus responseStatus = authResponse.getResponseStatus();

        if (responseStatus != null ){
            if (responseStatus.getCode() == 0){
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("token", authResponse.getToken());
                return "success";
            } else {
                loginMessage = responseStatus.getMessage();
            }
        }
        return "error";
    }
}
