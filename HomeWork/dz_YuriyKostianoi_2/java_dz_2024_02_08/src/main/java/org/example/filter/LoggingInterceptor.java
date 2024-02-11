package org.example.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Collections;

public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle Request URL: " + request.getRequestURL());
        System.out.println("preHandle Request Method: " + request.getMethod());
        System.out.println("preHandle Request Parameters: " + Collections.list(request.getParameterNames()));
        System.out.println("preHandle Request Headers: " + Collections.list(request.getHeaderNames()));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("preHandle Response Status: " + response.getStatus());
        System.out.println("preHandle Response Headers: " + response.getHeaderNames());
    }
}
