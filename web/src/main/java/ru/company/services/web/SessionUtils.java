package ru.company.services.web;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public abstract class SessionUtils {

    private SessionUtils() {
    }

    public static HttpSession getHttpSession(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        return session;
    }

}
