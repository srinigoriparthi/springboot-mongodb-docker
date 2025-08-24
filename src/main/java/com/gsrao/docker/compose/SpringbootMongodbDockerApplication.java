package com.gsrao.docker.compose;

import com.gsrao.docker.compose.dao.BookRepository;
import com.gsrao.docker.compose.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class SpringbootMongodbDockerApplication {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbDockerApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello, World!! I am from SpringbootMongodbDockerApplication");
		return "Hello, World!! I am from SpringbootMongodbDockerApplication";
	}

	@PostMapping("/save")
	public Book saveBook(@RequestBody Book book) {
		System.out.println("Saving book to the database: " + book);
		return bookRepository.save(book);
	}

	@GetMapping
	public List<Book> getAllBooks() {
		System.out.println("Getting all books from the database");
		return bookRepository.findAll();
	}
}
