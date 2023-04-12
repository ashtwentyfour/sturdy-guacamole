package com.ashcorp.censusdataoperations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "census")
public class Census {
  /**
  * Primary Key.
  */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  /**
  * State column.
  */
  @Column(nullable = false)
  private String state;

  /**
  * County column.
  */
  @Column(nullable = false)
  private String county;

  /**
  * Population column.
  */
  @Column(nullable = false)
  private Integer population;

  /**
  * Population of men column.
  */
  @Column(nullable = false)
  private Integer populationmen;

  /**
  * Tract ID column.
  */
  @Column(nullable = false, unique = true, updatable = false)
  private Long tractId;

  /**
  * Year column.
  */
  @Column(nullable = false)
  private Integer year;

  /**
  * Retrieve ID value.
  * @return ID value
  */
  public Integer getId() {
    return id;
  }

  /**
  * Set value for the 'id' column.
  * @param censusId ID of census record
  */
  public void setId(final Integer censusId) {
    this.id = censusId;
  }

  /**
  * Retrieve state value.
  * @return State value
  */
  public String getState() {
    return state;
  }

  /**
  * Set value for the 'state' column.
  * @param censusState State of census record
  */
  public void setState(final String censusState) {
    this.state = censusState;
  }

  /**
  * Retrieve county value.
  * @return County value
  */
  public String getCounty() {
    return county;
  }

  /**
  * Set value for the 'county' column.
  * @param censusCounty County of census record
  */
  public void setCounty(final String censusCounty) {
    this.county = censusCounty;
  }

  /**
  * Retrieve population value.
  * @return Total population value
  */
  public Integer getPopulation() {
    return population;
  }

  /**
  * Set value for the 'population' column.
  * @param censusPopulation Population recorded
  */
  public void setPopulation(final Integer censusPopulation) {
    this.population = censusPopulation;
  }

  /**
  * Retrieve population of men.
  * @return Population of men value
  */
  public Integer getPopulationMen() {
    return populationmen;
  }

  /**
  * Set value for the 'populationmen' column.
  * @param populationMen Population of men
  */
  public void setPopulationMen(final Integer populationMen) {
    this.populationmen = populationMen;
  }

  /**
  * Retrieve Tract ID value.
  * @return Tract ID value
  */
  public Long getTractId() {
    return tractId;
  }

  /**
  * Set value for the 'tractId' column.
  * @param censusTractId ID of census record
  */
  public void setTractId(final Long censusTractId) {
    this.tractId = censusTractId;
  }

  /**
  * Retrieve year value.
  * @return Year value
  */
  public Integer getYear() {
    return year;
  }

  /**
  * Set value for the 'year' column.
  * @param censusYear Year of census
  */
  public void setYear(final Integer censusYear) {
    this.year = censusYear;
  }
}
