package com.example.addservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    // CREATE
    public Visit createVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    // READ ALL
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    // READ BY ID
    public Visit getVisitById(Long id) {
        return visitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visit not found"));
    }

    // UPDATE
    public Visit updateVisit(Long id, Visit updatedVisit) {

        Visit existingVisit = getVisitById(id);

        existingVisit.setPropertyId(updatedVisit.getPropertyId());
        existingVisit.setUserId(updatedVisit.getUserId());
        existingVisit.setVisitDate(updatedVisit.getVisitDate());
        existingVisit.setStatus(updatedVisit.getStatus());

        return visitRepository.save(existingVisit);
    }

    // DELETE
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}