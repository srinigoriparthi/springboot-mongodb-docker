package com.gsrao.docker.compose.dao;

import com.gsrao.docker.compose.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}
