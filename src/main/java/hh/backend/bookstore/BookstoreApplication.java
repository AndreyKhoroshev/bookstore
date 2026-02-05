package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

@Bean
public CommandLineRunner demo(BookRepository repository) {
    return args -> {

        Book b1 = new Book("Pikku Prinssi","Antoine de Saint-Exupéry",1997,"9789510069851",15.2);
 		Book b2 = new Book("Muumipeikko ja pyrstötähti","Tove Jansson",2018,"9789510429204",16.9);
		Book b3 = new Book("Järven neito","Andrzej Sapkowski",2016,"9789510417997",11.2);

        repository.save(b1);
		repository.save(b2);
		repository.save(b3);
    };
}
}
