package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
        return args -> {

            // Save categories
            Category c1 = new Category("Fantasy");
            Category c2 = new Category("Classic");
            Category c3 = new Category("Fairy Tale");
			Category c4 = new Category("Comics");

            crepository.save(c1);
            crepository.save(c2);
            crepository.save(c3);
			crepository.save(c4);

            // Save books with categories
            repository.save(new Book("Pikku Prinssi",
                    "Antoine de Saint-Exupéry",
                    1997,
                    "9789510069851",
                    15.2,
                    c2));

            repository.save(new Book("Muumipeikko ja pyrstötähti",
                    "Tove Jansson",
                    2018,
                    "9789510429204",
                    16.9,
                    c3));

            repository.save(new Book("Järven neito",
                    "Andrzej Sapkowski",
                    2016,
                    "9789510417997",
                    11.2,
                    c1));

			repository.save(new Book("Aku Ankka",
                    "Kari Korhonen",
                    2020,
                    "9789515435346",
                    10.0,
                    c4));

			

            // Print categories
            System.out.println("Fetch all categories:");
            for (Category category : crepository.findAll()) {
                System.out.println(category);
            }

            // Print books
            System.out.println("Fetch all books:");
            for (Book book : repository.findAll()) {
                System.out.println(book);
            }
        };
    }
}
