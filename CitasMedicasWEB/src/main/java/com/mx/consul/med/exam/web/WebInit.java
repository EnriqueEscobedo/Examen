package com.mx.consul.med.exam.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer /*implements WebApplicationInitializer */{

    // llamado a spring security para iniciar contextos
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    // llamado a configuracion de BD, Swagger e interceptores
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    // configuracion de mapeo de servlets, jsp
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}