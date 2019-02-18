package ru.company.services.web;

import ru.company.services.personws.*;

import javax.faces.application.ResourceHandler;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURL = request.getContextPath() + "/login.xhtml";
        String token = null;

        if (session != null ){
            token = (String) session.getAttribute("token");
        }

        boolean loginRequest = request.getRequestURI().equals(loginURL);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");

        //check session
        TResponseStatus responseStatus =  null;

        if (token != null && !resourceRequest){
            try {
                AuthServiceImplService authService = new AuthServiceImplService();
                AuthServiceImpl authServiceImplPort = authService.getAuthServiceImplPort();
                TCheckSessionRequest checkSessionRequest = new TCheckSessionRequest();
                checkSessionRequest.setToken(token);
                responseStatus = authServiceImplPort.checkSession(checkSessionRequest);
            } catch (Exception e){
                System.out.println("error");
            }
        }

        boolean loggedIn = responseStatus !=null && responseStatus.getCode() == 0;

        if (!loggedIn && !loginRequest && !resourceRequest){
            response.sendRedirect("login.xhtml");
            return;
        }

        if (loggedIn && loginRequest){
            response.sendRedirect(request.getContextPath());
            return;
        }


        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
