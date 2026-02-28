package hh.backend.bookstore.web;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private final BookRepository repository;

    public BookRestController(BookRepository repository) {
        this.repository = repository;
    }

    // GET all
    @GetMapping
    public Iterable<Book> bookListRest() {
        return repository.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Book findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId).orElse(null);
    }

    // POST new book
    @PostMapping
    public Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }
}