package mk.ukim.finki.labb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "book-list-servlet",urlPatterns = "/listBooks")
public class BookListServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final BookService bookService;

    public BookListServlet(SpringTemplateEngine springTemplateEngine, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context= new WebContext(webExchange);
        context.setVariable("ipAddress",req.getRemoteAddr());
        context.setVariable("bookList",bookService.listBooks());
        req.getSession().setAttribute("bookIsbn", req.getParameter("bookIsbn"));

        this.springTemplateEngine.process("listBooks.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String bookIsbn = req.getParameter("bookIsbn");
        Book book=bookService.findBookByIsbn(bookIsbn);

        req.getSession().setAttribute("bookIsbn", req.getParameter("bookIsbn"));
        resp.sendRedirect("/author?bookIsbn=" + bookIsbn);

    }
}
