package ru.company.services.web.beans;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
@Data
public class LoginBean {

    private String login;
    private String password;

    public String doLogin(){
        return "userlist";
    }
}
