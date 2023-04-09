package com.ashcorp.censusdataoperations.web;

import com.ashcorp.censusdataoperations.entity.Census;
import com.ashcorp.censusdataoperations.exception.CensusNotFoundException;
import com.ashcorp.censusdataoperations.repository.CensusRepository;
import com.ashcorp.censusdataoperations.service.CensusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller 
@RequestMapping(path="/data/census") // path
public class MainController {
  @Autowired
  private CensusRepository censusRepository;

  private CensusService censusService;

  @Autowired
  public void setCensusService(CensusService censusService) { this.censusService = censusService; }

  @PostMapping(path="/add") 
  public @ResponseBody ResponseEntity<Census> addNewCensusTract (@RequestParam String state
      , @RequestParam String county, @RequestParam Integer population
      , @RequestParam Integer populationmen, @RequestParam Long tractId
      , @RequestParam Integer year) {
    
    Census c = new Census();
    c.setState(state);
    c.setCounty(county);
    c.setPopulation(population);
    c.setPopulationMen(populationmen);
    c.setTractId(tractId);
    c.setYear(year);
    try {
        censusRepository.save(c);
    } catch(DataIntegrityViolationException exception) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Census Record Exists");
    }
    return new ResponseEntity<Census>(c, HttpStatus.CREATED);
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Census> getAllCensus() {
    return censusRepository.findAll();
  }

  @GetMapping(path="/{id}")
  public ResponseEntity<Census> getCensus(@PathVariable Long id) {
    try {
        return new ResponseEntity<Census>(censusService.findCensus(id), HttpStatus.OK);
    } catch (CensusNotFoundException exception) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Census Record Not Found");
    }
  }

}