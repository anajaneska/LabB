package mk.ukim.finki.labb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.service.AuthorService;
import mk.ukim.finki.labb.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "author-servlet",urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorServlet(SpringTemplateEngine springTemplateEngine, AuthorService authorService,BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
        this.bookService=bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context= new WebContext(webExchange);

        context.setVariable("authorsList",authorService.listAuthors());
        context.setVariable("bookIsbn", req.getParameter("bookIsbn"));
        this.springTemplateEngine.process("authorList.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String bookIsbn = req.getParameter("bookIsbn");
        Long id= Long.valueOf(req.getParameter("authorId"));
        Author a=authorService.findById(id);
        bookService.findBookByIsbn(bookIsbn).addAuthor(a);

        req.getSession().setAttribute("book", bookService.findBookByIsbn(bookIsbn));
        resp.sendRedirect("/bookDetails?bookIsbn="+bookIsbn);

    }
}
