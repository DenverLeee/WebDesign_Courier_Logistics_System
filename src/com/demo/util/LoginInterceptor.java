package com.demo.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Interceptors
 */
public class LoginInterceptor implements HandlerInterceptor {

    //@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        //Remove error message
        session.removeAttribute("alert_msg");
        //Login blocking
        String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
        String[] access = new String[]{"login", "logout", "register", ".css", ".js", ".png", ".jpg", "validationCode"};
        for (String action : access) {
            if (uri.toLowerCase().contains(action.toLowerCase())) {
                return true;
            }
        }
        if (session.getAttribute("loginUser") == null) {
            session.setAttribute("alert_msg", "Error,Please Login！");
            response.sendRedirect("login.jsp");
            return false;
        }
        return true;
    }

	//@Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

	//@Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}