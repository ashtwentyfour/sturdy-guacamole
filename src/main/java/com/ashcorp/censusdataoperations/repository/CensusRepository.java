package com.ashcorp.censusdataoperations.repository;

import com.ashcorp.censusdataoperations.entity.Census;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
* CRUD Repository for census data.
* @author Ashwin Menon
* @version 1.0
* @since 2023-04-07
*/
public interface CensusRepository extends CrudRepository<Census, Integer> {
    /**
    * Retrieve record by Tract ID.
    * @param tractId Tract ID
    * @return Census record matching the Tract ID
    */
    Optional<Census> findByTractId(Long tractId);
}
