package mk.ukim.finki.labb.service;

import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.model.BookStore;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
    void deleteByIsbn(String isbn);
    Optional<Book> saveBook(String isbn, String title, String genre, int year, Long bookStore);
}
