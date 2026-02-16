package com.nit.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BrowserRestrictionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object handler) throws Exception {

        System.out.println("BrowserRestrictionInterceptor.preHandle()");

        String userAgent = req.getHeader("User-Agent");

        // Allow only Chrome & Edge
        if (userAgent != null &&
           (userAgent.contains("Chrome") || userAgent.contains("Edg"))) {

            return true; // Allowed browser
        }

        // If not allowed browser
        req.getRequestDispatcher("/browser-error.jsp").forward(req, res);
        return false;
    }
}
