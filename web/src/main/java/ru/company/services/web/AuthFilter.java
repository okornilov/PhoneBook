package ru.company.services.web;

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
        boolean loggedIn = (session != null) && (session.getAttribute("token") != null);
        boolean loginRequest = request.getRequestURI().equals(loginURL);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");

        if (loggedIn && loginRequest){
            response.sendRedirect("userlist.xhtml");
            return;
        }

        if (!loggedIn && !loginRequest && !resourceRequest){
            response.sendRedirect("login.xhtml");
            return;
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
