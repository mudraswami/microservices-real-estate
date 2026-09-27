package com.example.visitservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.visitservice.Visit;
import com.example.visitservice.service.VisitService;

@RestController
@RequestMapping("/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    // Get all visits
    @GetMapping
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    // Get visit by ID
    @GetMapping("/{id}")
    public Visit getVisitById(@PathVariable Long id) {
        return visitService.getVisitById(id);
    }

    // Add new visit
    @PostMapping
    public Visit addVisit(@RequestBody Visit visit) {
        return visitService.addVisit(visit);
    }

    // Update visit
    @PutMapping("/{id}")
    public Visit updateVisit(
            @PathVariable Long id,
            @RequestBody Visit visit) {
        return visitService.updateVisit(id, visit);
    }

    // Delete visit
    @DeleteMapping("/{id}")
    public String deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
        return "Visit deleted successfully";
    }
}