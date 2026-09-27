package com.example.visitservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.visitservice.Visit;
import com.example.visitservice.repository.VisitRepository;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    // Get all visits
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    // Get visit by ID
    public Visit getVisitById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    // Add visit
    public Visit addVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    // Update visit
    public Visit updateVisit(Long id, Visit visit) {

        Visit existing = visitRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setPropertyId(visit.getPropertyId());
            existing.setVisitorName(visit.getVisitorName());
            existing.setVisitorEmail(visit.getVisitorEmail());
            existing.setVisitDate(visit.getVisitDate());
            existing.setVisitTime(visit.getVisitTime());
            existing.setStatus(visit.getStatus());

            return visitRepository.save(existing);
        }

        return null;
    }

    // Delete visit
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}