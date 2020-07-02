package edu.co.covid.repository;

import edu.co.covid.controller.dto.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {
    Optional <Person> findByFullName (String fullName);
    Optional <Person> findByDocumentNumber (String documentNumber);
}