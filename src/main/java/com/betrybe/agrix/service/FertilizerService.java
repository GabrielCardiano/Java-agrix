package com.betrybe.agrix.service;

import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Fertilizer;
import com.betrybe.agrix.model.repository.CropRepository;
import com.betrybe.agrix.model.repository.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;
  private final CropRepository cropRepository;

  /**
   * Instantiates a new Fertilizer service.
   *
   * @param fertilizerRepository the fertilizer repository
   */
  @Autowired
  public FertilizerService(
      FertilizerRepository fertilizerRepository,
      CropRepository cropRepository
  ) {
    this.fertilizerRepository = fertilizerRepository;
    this.cropRepository = cropRepository;
  }

  public Fertilizer insertFertilizer(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  public List<Fertilizer> getAllFertilizers() {
    return fertilizerRepository.findAll();
  }

  public Fertilizer getFertilizerById(Long id) {
    return fertilizerRepository.findById(id)
        .orElseThrow(FertilizerNotFoundException::new);
  }

  public List<Fertilizer> findAllFertilizersFromCrop(Long id) {
    Crop crop = cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
    return crop.getFertilizer();
  }

  /**
   * Insert fertilizer in crop.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   */

  public void insertFertilizerInCrop(Long cropId, Long fertilizerId) {
    Crop crop = cropRepository.findById(cropId).orElseThrow(CropNotFoundException::new);
    Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
        .orElseThrow(FertilizerNotFoundException::new);
    
    crop.getFertilizer().add(fertilizer);
    cropRepository.save(crop);
  }

}
