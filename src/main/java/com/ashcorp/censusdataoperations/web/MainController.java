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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping(path = "/data/census") // path
public class MainController {
  /**
  * CensusRepository object.
  */
  @Autowired
  private CensusRepository censusRepository;

  /**
  * CensusService object.
  */
  private CensusService censusService;

  /**
  * Initialize CensusService object.
  * @param service CensusService object
  */
  @Autowired
  public void setCensusService(final CensusService service) {
                  this.censusService = service;
                }

  /**
  * Add a new census record to the database.
  * @param state State value
  * @param county County value
  * @param population Population value
  * @param populationmen Population of men value
  * @param tractId Tract ID
  * @param year Year value
  * @return JSON representation of data added
  */
  @PostMapping(path = "/add")
  public @ResponseBody ResponseEntity<Census> addNewCensusTract(
         @RequestParam final String state,
         @RequestParam final String county,
         @RequestParam final Integer population,
         @RequestParam final Integer populationmen,
         @RequestParam final Long tractId,
         @RequestParam final Integer year) {

          Census c = new Census();
          c.setState(state);
          c.setCounty(county);
          c.setPopulation(population);
          c.setPopulationMen(populationmen);
          c.setTractId(tractId);
          c.setYear(year);
    try {
        censusRepository.save(c);
    } catch (DataIntegrityViolationException exception) {
        throw new ResponseStatusException(HttpStatus.CONFLICT,
                  "Census Record Exists");
    }
    return new ResponseEntity<Census>(c, HttpStatus.CREATED);
  }

  /**
  * Return all the census data.
  * @return JSON array with all the records
  */
  @GetMapping(path = "/all")
  public @ResponseBody Iterable<Census> getAllCensus() {
    return censusRepository.findAll();
  }

  /**
  * Return census record by Tract ID.
  * @param id Tract ID
  * @return Match census record object
  */
  @GetMapping(path = "/{id}")
  public ResponseEntity<Census> getCensus(@PathVariable final Long id) {
    try {
        return new ResponseEntity<Census>(censusService.findCensus(id),
                   HttpStatus.OK);
    } catch (CensusNotFoundException exception) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                  "Census Record Not Found");
    }
  }

}
