package mk.ukim.finki.labb.service.impl;

import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.model.exceptions.NonValidIdException;
import mk.ukim.finki.labb.model.exceptions.NonValidIsbnException;
import mk.ukim.finki.labb.repository.AuthorRepository;
import mk.ukim.finki.labb.repository.BookRepository;
import mk.ukim.finki.labb.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        Author a=authorRepository.findById(authorId).orElseThrow(NonValidIdException::new);
        Book b=bookRepository.findByIsbn(isbn).orElseThrow(NonValidIsbnException::new);
        return bookRepository.addAuthorToBook(a,b);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(NonValidIsbnException::new);
    }
}
