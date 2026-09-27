package com.example.addservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.addservice.service.AddService;

@RestController
public class AddController {

    @Autowired
    private AddService addService;

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return addService.add(a, b);
    }
}