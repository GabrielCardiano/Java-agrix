package com.betrybe.agrix.dto;

import com.betrybe.agrix.model.entity.Crop;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Crop dto.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    Long farmId
) {

  /**
   * Get a crop into a dto.
   *
   * @param crop the crop
   * @return the crop dto
   */
  public static CropDto cropToDto(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getPlantedDate(),
        crop.getHarvestDate(),
        crop.getFarm().getId()
    );
  }

  /**
   * Get a crop list into a dto.
   *
   * @param cropList the crop list
   * @return the list
   */
  public static List<CropDto> cropListToDto(List<Crop> cropList) {
    return cropList.stream()
        .map(CropDto::cropToDto)
        .toList();

    /* Solução CropDto::cropDto significa o mesmo que no código a seguir;

    * return cropList.stream()
          .map(crop -> new CropDto(
              crop.getId(),
              crop.getName(),
              crop.getPlantedArea(),
              crop.getPlantedDate(),
              crop.getHavestDate(),
              crop.getFarm().getId(),
              crop.getFertilizer()
          ))
          .toList();
    */
  }
}
