package edu.co.Covid.repository;

import edu.co.Covid.controller.dto.Worship;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorshipRepository extends MongoRepository <Worship, String> {

}
