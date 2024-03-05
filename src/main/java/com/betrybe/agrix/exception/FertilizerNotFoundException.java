package com.betrybe.agrix.exception;


/**
 * The type Farm not found exception.
 */
public class FertilizerNotFoundException extends RuntimeException {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
