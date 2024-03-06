package com.betrybe.agrix.dto;

import com.betrybe.agrix.model.entity.Person;
import com.betrybe.agrix.security.Role;

/**
 * The type Person create dto.
 */
public record PersonCreateDto(String username, String password, Role role) {

  public Person toPerson() {
    return new Person(null, username, password, role);
  }
}
