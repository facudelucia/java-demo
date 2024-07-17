/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author facun
 */
package com.example.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.ManagedBean;

@ManagedBean
@Component
public class HelloBean {

    private String message = "Hello, JSF with Spring Boot!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

