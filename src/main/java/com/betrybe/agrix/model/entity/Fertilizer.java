package com.betrybe.agrix.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * The type Fertilizer.
 */
@Entity
@Table(name = "fertilizer")
public class Fertilizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String brand;
  private String composition;

  @ManyToMany(mappedBy = "fertilizer")
  @JsonIgnore
  private List<Crop> crop;

  public Fertilizer() {
  }

  /**
   * Instantiates a new Fertilizer.
   *
   * @param id          the id
   * @param name        the name
   * @param brand       the brand
   * @param composition the composition
   */
  public Fertilizer(Long id, String name, String brand, String composition, List<Crop> crop) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
    this.crop = crop;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }

  public List<Crop> getCrop() {
    return crop;
  }

  public void setCrop(List<Crop> crop) {
    this.crop = crop;
  }
}
