package com.mastek.hrapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.JobPositions;

@Repository // mark document as repository
public interface JobPositionsDAO extends MongoRepository<JobPositions, Integer>{ // map Doc and Identifier type with MongoRepositry
	
}
