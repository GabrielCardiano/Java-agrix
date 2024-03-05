package com.betrybe.agrix.dto;

import com.betrybe.agrix.model.entity.Farm;

/**
 * Get a dto into a Farm.
 */
public record FarmDto(Long id, String name, Double size) {

  public Farm toFarm() {
    return new Farm(id, name, size, null);
  }

}
