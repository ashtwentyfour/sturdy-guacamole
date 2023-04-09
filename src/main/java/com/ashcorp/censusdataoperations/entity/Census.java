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
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String state;

  @Column(nullable = false)
  private String county;

  @Column(nullable = false)
  private Integer population;

  @Column(nullable = false)
  private Integer populationmen;

  @Column(nullable = false, unique = true, updatable = false)
  private Long tractId;

  @Column(nullable = false)
  private Integer year;

  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public Integer getPopulationMen() {
    return populationmen;
  }

  public void setPopulationMen(Integer populationmen) {
    this.populationmen = populationmen;
  }

  public Long getTractId() {
    return tractId;
  }

  public void setTractId(Long tractId) {
    this.tractId = tractId;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }
}