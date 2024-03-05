package com.betrybe.agrix.service;

import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.model.repository.CropRepository;
import com.betrybe.agrix.model.repository.FarmRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FarmRepository farmRepository;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   * @param farmRepository the farm repository
   */
  @Autowired
  public CropService(CropRepository cropRepository, FarmRepository farmRepository) {
    this.cropRepository = cropRepository;
    this.farmRepository = farmRepository;
  }

  /**
   * Insert crop.
   *
   * @param crop   the crop
   * @param farmId the id
   * @return the crop
   */
  public Crop insertCropInFarm(Crop crop, Long farmId) {
    Farm farm = farmRepository.findById(farmId).orElseThrow(FarmNotFoundException::new);
    crop.setFarm(farm);
    return cropRepository.save(crop);
  }

  public List<Crop> getFarmCrops(Long farmId) {
    Farm farm = farmRepository.findById(farmId).orElseThrow(FarmNotFoundException::new);
    return farm.getCrops();
  }

  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }

  public Crop getCropById(Long id) {
    return cropRepository.findById(id)
        .orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> getCropByHarvestDate(LocalDate start, LocalDate end) {
    return cropRepository.findByHarvestDateBetween(start, end);
  }
}
