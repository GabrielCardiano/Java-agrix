package com.betrybe.agrix.service;

import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.model.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm insertFarm(Farm farm) {
    // TODO: add tratamento de erro
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    // TODO: add tratamento de erro.
    return farmRepository.findAll();
  }

  public Farm getFarmById(Long id) {
    return farmRepository.findById(id)
        .orElseThrow(FarmNotFoundException::new);
  }
}
