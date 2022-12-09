package com.example.demo.DemoApplication.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void doStuff(){
        System.out.println("Only admin stuff");
    }
}
