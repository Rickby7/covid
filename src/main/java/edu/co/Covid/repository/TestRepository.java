package edu.co.covid.repository;

import edu.co.covid.controller.dto.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository <Test, String> {

}
