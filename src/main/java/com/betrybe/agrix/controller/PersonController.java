package com.betrybe.agrix.controller;

import static com.betrybe.agrix.dto.PersonResponseDto.toPersonResponse;

import com.betrybe.agrix.dto.PersonCreateDto;
import com.betrybe.agrix.dto.PersonResponseDto;
import com.betrybe.agrix.model.entity.Person;
import com.betrybe.agrix.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Person controller.
 */
@RestController
@RequestMapping(path = "/persons")
public class PersonController {

  private final PersonService personService;

  /**
   * Instantiates a new Person controller.
   *
   * @param personService the person service
   */
  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create person response entity.
   *
   * @param personDto the person dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<PersonResponseDto> createPerson(@RequestBody PersonCreateDto personDto) {
    Person person = personService.create(personDto.toPerson());
    return ResponseEntity.status(HttpStatus.CREATED).body(toPersonResponse(person));
  }
}
