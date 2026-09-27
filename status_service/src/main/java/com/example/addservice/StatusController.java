package com.example.addservice;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    // CREATE
    @PostMapping
    public Status createStatus(@RequestBody Status status) {
        return statusService.createStatus(status);
    }

    // READ ALL
    @GetMapping
    public List<Status> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Status updateStatus(
            @PathVariable Long id,
            @RequestBody Status status) {
        return statusService.updateStatus(id, status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
        return "Status deleted successfully";
    }
}