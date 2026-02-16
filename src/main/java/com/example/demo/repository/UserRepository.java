package com.example.demo.repository;

import com.example.demo.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntry, ObjectId> {

}
