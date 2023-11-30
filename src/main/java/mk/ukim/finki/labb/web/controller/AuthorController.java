package mk.ukim.finki.labb.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.model.BookStore;
import mk.ukim.finki.labb.service.AuthorService;
import mk.ukim.finki.labb.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("")
    public String getAuthorsPage(@RequestParam(required = false) String error, Model model){
        List<Author> authors=this.authorService.listAuthors();
        model.addAttribute("authors",authors);
        return "authorList";
    }
    /*@PostMapping("/add/{isbn}")
    public String addAuthorToBook(@RequestParam Long authorId, @RequestParam String isbn){
        this.bookService.addAuthorToBook(authorId,isbn);
        return "redirect:/products";
    }*/
    @PostMapping("/add/{authorId}")
    public String addAuthorToBook(@PathVariable Long authorId, HttpServletRequest req){
        try{
            Book book=(Book)req.getSession().getAttribute("book");
            this.bookService.addAuthorToBook(authorId,book.getIsbn());
            return "redirect:/products";
        }catch (RuntimeException exception){
            return "redirect:/authors?error="+exception.getMessage();
        }
    }
    @GetMapping("/add-form/{authorId}")
    public String editAuthorPage(@PathVariable Long authorId,Model model){
        if(this.authorService.findById(authorId)!=null){
            Author author=this.authorService.findById(authorId);
            model.addAttribute("author",author);
            return "edit-author";
        }
        return "redirect:/author?error=AuthorNotFound";
    }
    @GetMapping("/add-form")
    public String addAuthorPage(Model model){
        List<Author> authors=this.authorService.listAuthors();
        model.addAttribute("authors",authors);
        return "edit-author";
    }
    @PostMapping("/add")
    public String saveAuthor(@RequestParam String name,@RequestParam String surname,@RequestParam String bio){
        this.authorService.saveAuthor(name,surname,bio);
        return "redirect:/authors";
    }
}
