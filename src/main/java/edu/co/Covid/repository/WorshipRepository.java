package edu.co.covid.repository;

import edu.co.covid.controller.dto.Worship;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorshipRepository extends MongoRepository <Worship, String> {

}
