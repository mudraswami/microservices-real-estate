package com.example.multiply_service.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplyService {

    public int multiply(int a, int b) {
        return a * b;
    }

}