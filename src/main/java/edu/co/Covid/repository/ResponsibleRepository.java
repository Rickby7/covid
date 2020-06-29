package edu.co.Covid.repository;

import edu.co.Covid.controller.dto.Responsible;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponsibleRepository extends MongoRepository <Responsible, String> { }