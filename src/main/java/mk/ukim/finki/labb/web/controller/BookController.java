package mk.ukim.finki.labb.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.model.BookStore;
import mk.ukim.finki.labb.service.AuthorService;
import mk.ukim.finki.labb.service.BookService;
import mk.ukim.finki.labb.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final BookStoreService bookStoreService;

    public BookController(BookService bookService,AuthorService authorService,BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.authorService=authorService;
        this.bookStoreService=bookStoreService;
    }

    @GetMapping("")
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        List<Book> books=this.bookService.listBooks();
        model.addAttribute("books",books);
        return "listBooks";
    }
    @PostMapping("/delete/{isbn}")
    public String deleteBook(@PathVariable String isbn){
       this.bookService.deleteByIsbn(isbn);
        return "redirect:/books";
    }
    @GetMapping("/add-form/{isbn}")
    public String editBookPage(@PathVariable String isbn,Model model){
        if(this.bookService.findBookByIsbn(isbn)!=null){
            Book book=this.bookService.findBookByIsbn(isbn);
            List<BookStore> bookStores=this.bookStoreService.findAll();
            model.addAttribute("book",book);
            model.addAttribute("bookStores",bookStores);
            return "add-book";
        }
        return "redirect:/books?error=BookNotFound";
    }
    @GetMapping("/add-form")
    public String addBookPage(Model model){
        List<Author> authors=this.authorService.listAuthors();
        List<BookStore> bookStores=this.bookStoreService.findAll();
        model.addAttribute("authors",authors);
        model.addAttribute("bookStores",bookStores);
        return "add-book";
    }
    @PostMapping("/add")
    public String saveBook(@RequestParam String isbn,@RequestParam String title,@RequestParam String genre,@RequestParam int year,@RequestParam Long bookStore){
        this.bookService.saveBook(isbn,title,genre,year,bookStore);
        return "redirect:/books";
    }

}
