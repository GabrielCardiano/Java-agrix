package com.betrybe.agrix.dto;

import com.betrybe.agrix.model.entity.Fertilizer;

/**
 * The type Fertilizer dto.
 */
public record FertilizerCreateDto(Long id, String name, String brand, String composition) {

  public Fertilizer toFertilizer() {
    return new Fertilizer(id, name, brand, composition, null);
  }
}
