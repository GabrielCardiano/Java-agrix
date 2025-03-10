package com.betrybe.agrix.model.repository;

import com.betrybe.agrix.model.entity.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Crop repository.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

  List<Crop> findByHarvestDateBetween(LocalDate start, LocalDate end);
}
