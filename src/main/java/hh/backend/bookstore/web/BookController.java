package hh.backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.CategoryRepository;

import org.springframework.ui.Model;




@Controller

public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
private CategoryRepository crepository;

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";

    // DELETE BOOK 
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable ("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:/booklist";
    }
   // ADD BOOK 
@GetMapping("/add")
public String addBook(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("categories", crepository.findAll());
    return "addbook";
}
    // SAVE BOOK
   @PostMapping(value = "/save")
   public String save(Book book){
        repository.save(book);
        return "redirect:/booklist";
        }
// EDIT BOOK
        @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        
        model.addAttribute("book", book);
        return "addbook";
   }

    }
