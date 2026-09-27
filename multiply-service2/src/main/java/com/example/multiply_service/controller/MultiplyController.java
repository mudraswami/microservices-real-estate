package com.example.multiply_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.multiply_service.service.MultiplyService;

@RestController
public class MultiplyController {

    @Autowired
    private MultiplyService multiplyService;

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a,
                        @RequestParam int b) {

        return multiplyService.multiply(a, b);
    }
}