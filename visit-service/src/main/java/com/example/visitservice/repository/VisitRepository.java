package com.example.visitservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.visitservice.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

}