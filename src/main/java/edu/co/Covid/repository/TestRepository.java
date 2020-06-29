package edu.co.Covid.repository;

import edu.co.Covid.controller.dto.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository <Test, String> {

}
