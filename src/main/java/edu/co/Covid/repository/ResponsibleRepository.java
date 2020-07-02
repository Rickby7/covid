package edu.co.covid.repository;

import edu.co.covid.controller.dto.Responsible;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponsibleRepository extends MongoRepository <Responsible, String> { }