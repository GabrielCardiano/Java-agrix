package com.betrybe.agrix.dto;

import com.betrybe.agrix.model.entity.Person;
import com.betrybe.agrix.security.Role;

/**
 * The type Person response dto.
 */
public record PersonResponseDto(Long id, String username, Role role) {

  /**
   * To person response person response dto.
   *
   * @param person the person
   * @return the person response dto
   */
  public static PersonResponseDto toPersonResponse(Person person) {
    return new PersonResponseDto(
        person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }
}
