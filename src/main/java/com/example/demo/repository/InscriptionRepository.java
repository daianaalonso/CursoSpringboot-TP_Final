package com.example.demo.repository;

import com.example.demo.domain.Inscription;
import com.example.demo.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    List<Inscription> findByState(State state);

    @Query(value = "SELECT * FROM inscription WHERE state = :state", nativeQuery = true)
    List<Inscription> findByStateQueryNativa(@Param("state") String state);
}
