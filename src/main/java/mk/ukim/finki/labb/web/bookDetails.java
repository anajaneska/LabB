package mk.ukim.finki.labb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.service.AuthorService;
import mk.ukim.finki.labb.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/bookDetails")
public class bookDetails extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private BookService bookService;
    private final AuthorService authorService;

    public bookDetails(SpringTemplateEngine springTemplateEngine, BookService bookService, AuthorService authorService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context= new WebContext(webExchange);
        String bookIsbn = (String) req.getSession().getAttribute("bookIsbn");
        Book b =  bookService.findBookByIsbn(bookIsbn);
        context.setVariable("book",b);
        context.setVariable("year",b.getYear());
        context.setVariable("genre",b.getGenre());
        context.setVariable("authors",b.getAuthors());
        this.springTemplateEngine.process("bookDetails.html",context,resp.getWriter());
    }
}
