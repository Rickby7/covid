package edu.co.Covid.repository;

import edu.co.Covid.controller.dto.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {
    Optional <Person> findByFullName (String fullName);
    Optional <Person> findByDocumentNumber (String documentNumber);
}