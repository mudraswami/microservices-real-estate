package com.example.addservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    // CREATE
    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    // READ ALL
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    // READ BY ID
    public Status getStatusById(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));
    }

    // UPDATE
    public Status updateStatus(Long id, Status updatedStatus) {

        Status existingStatus = getStatusById(id);

        existingStatus.setPropertyId(updatedStatus.getPropertyId());
        existingStatus.setStatus(updatedStatus.getStatus());
        existingStatus.setDescription(updatedStatus.getDescription());

        return statusRepository.save(existingStatus);
    }

    // DELETE
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}