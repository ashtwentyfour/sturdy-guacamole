package com.ashcorp.censusdataoperations.service;

import com.ashcorp.censusdataoperations.entity.Census;
import com.ashcorp.censusdataoperations.exception.CensusNotFoundException;
import com.ashcorp.censusdataoperations.repository.CensusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CensusService {
    @Autowired
    private CensusRepository censusRepository;

    public Census findCensus(Long id) {
        Optional<Census> c = censusRepository.findByTractId(id);

        if(c.isPresent())
            return c.get();
        else
            throw new CensusNotFoundException("Census Record Not Found");
    }

}
