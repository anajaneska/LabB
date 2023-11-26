package mk.ukim.finki.labb.service;

import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
}
