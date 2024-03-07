package com.betrybe.agrix.controller;

import static com.betrybe.agrix.dto.CropDto.cropListToDto;
import static com.betrybe.agrix.dto.CropDto.cropToDto;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Fertilizer;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FertilizerService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping(path = "/crops")
public class CropController {

  private final CropService cropService;
  private final FertilizerService fertilizerService;

  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService the crop service
   */
  @Autowired
  public CropController(CropService cropService, FertilizerService fertilizerService) {
    this.cropService = cropService;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping
  @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
  public ResponseEntity<List<CropDto>> getAllCrops() {
    List<Crop> cropList = cropService.getAllCrops();
    return ResponseEntity.ok(cropListToDto(cropList));
  }

  @GetMapping("{id}")
  public ResponseEntity<CropDto> getOneCrop(@PathVariable Long id) {
    Crop crop = cropService.getCropById(id);
    return ResponseEntity.ok(cropToDto(crop));
  }

  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> searchCrop(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    List<Crop> cropList = cropService.getCropByHarvestDate(start, end);
    return ResponseEntity.ok(cropListToDto(cropList));
  }

  /**
   * Createfertilizer in crop response entity.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the response entity
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> createfertilizerInCrop(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) {
    fertilizerService.insertFertilizerInCrop(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }

  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<Fertilizer>> getFertilizersfromCrop(@PathVariable Long cropId) {
    List<Fertilizer> fertilizerList = fertilizerService.findAllFertilizersFromCrop(cropId);
    return ResponseEntity.ok(fertilizerList);
  }
}
