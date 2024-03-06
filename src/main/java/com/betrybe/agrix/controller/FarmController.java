package com.betrybe.agrix.controller;

import static com.betrybe.agrix.dto.CropDto.cropListToDto;
import static com.betrybe.agrix.dto.CropDto.cropToDto;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FarmCreateDto;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping(path = "/farms")
public class FarmController {

  private final FarmService farmService;
  private final CropService cropService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   */
  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * Create farm response entity.
   *
   * @param farmDto the farm dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Farm> createFarm(@RequestBody FarmCreateDto farmDto) {
    // receive farmDTO tranform to farm
    Farm newFarm = farmService.insertFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  /**
   * Get all farms.
   *
   * @return the all farms
   */
  @GetMapping
  public ResponseEntity<List<Farm>> getAllFarms() {
    List<Farm> allFarms = farmService.getAllFarms();
    return ResponseEntity.ok(allFarms);
  }

  /**
   * Get one farm.
   *
   * @param id the id
   * @return the one farm
   */
  @GetMapping("/{id}")
  public ResponseEntity<Farm> getOneFarm(@PathVariable Long id) {
    Farm farm = farmService.getFarmById(id);
    return ResponseEntity.status(HttpStatus.OK).body(farm);
  }

  /**
   * Create crop into a farm.
   *
   * @param crop the crop
   * @param id   the id
   * @return the response entity
   */
  @PostMapping("/{id}/crops")
  public ResponseEntity<CropDto> createCrop(
      @RequestBody Crop crop,
      @PathVariable Long id
  ) {
    Crop newCrop = cropService.insertCropInFarm(crop, id);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(cropToDto(newCrop));
  }

  /**
   * Gets all crops from a farm.
   *
   * @param id the id
   * @return the all crops
   */
  @GetMapping("/{id}/crops")
  public ResponseEntity<List<CropDto>> getAllCrops(@PathVariable Long id) {
    List<Crop> allCrops = cropService.getFarmCrops(id);
    return ResponseEntity.ok(cropListToDto(allCrops));
  }
}
