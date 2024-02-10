package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class}; // указали Spring-конфигурацию, как ранее указывали при создании контекста
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // сопоставляем, какие пути будут отправляться на dispatcherServlet
    }
}
