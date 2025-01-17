package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<HelloServlet> helloServletRegistration() {
        ServletRegistrationBean<HelloServlet> registrationBean = new ServletRegistrationBean<>(new HelloServlet(), "/hello");
        registrationBean.setName("HelloServlet");
        return registrationBean;
    }
}
