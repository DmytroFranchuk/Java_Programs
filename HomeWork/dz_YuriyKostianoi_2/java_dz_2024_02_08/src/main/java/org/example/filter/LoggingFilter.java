package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
@WebFilter(filterName = "loggingFilter", urlPatterns = "/*")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("doFilter Request URL: " + request.getRequestURL());
        System.out.println("doFilter Request Method: " + request.getMethod());
        System.out.println("doFilter Request Parameters: " + Collections.list(request.getParameterNames()));
        System.out.println("doFilter Request Headers: " + Collections.list(request.getHeaderNames()));
        filterChain.doFilter(request, response);
        System.out.println("doFilter Response Status: " + response.getStatus());
        System.out.println("doFilter Response Headers: " + response.getHeaderNames());
    }
}
