package com.betrybe.agrix.model.repository;

import com.betrybe.agrix.model.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Fertilizer repository.
 */
@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
