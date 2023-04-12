package com.ashcorp.censusdataoperations.service;

import com.ashcorp.censusdataoperations.entity.Census;
import com.ashcorp.censusdataoperations.exception.CensusNotFoundException;
import com.ashcorp.censusdataoperations.repository.CensusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
* Helper functions used to support CRUD operations on census data.
* @author Ashwin Menon
* @version 1.0
* @since 2023-04-07
*/
@Service
public class CensusService {
    /**
    * Declaring object used for CRUD operations on the MySQL DB.
    */
    @Autowired
    private CensusRepository censusRepository;

    /**
    * Retrieves a record by Tract ID.
    * @param id Tract ID
    * @return Census record matching the Tract ID
    */
    public Census findCensus(final Long id) {
        Optional<Census> c = censusRepository.findByTractId(id);

        if (c.isPresent()) {
            return c.get();
        } else {
            throw new CensusNotFoundException("Census Record Not Found");
        }
    }

}
