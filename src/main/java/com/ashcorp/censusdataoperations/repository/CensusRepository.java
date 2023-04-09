package com.ashcorp.censusdataoperations.repository;

import com.ashcorp.censusdataoperations.entity.Census;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CensusRepository extends CrudRepository<Census, Integer> {
    Optional<Census> findByTractId(Long tractId);
}