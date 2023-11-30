package mk.ukim.finki.labb.service.impl;

import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.model.BookStore;
import mk.ukim.finki.labb.model.exceptions.NonValidIdException;
import mk.ukim.finki.labb.model.exceptions.NonValidIsbnException;
import mk.ukim.finki.labb.repository.AuthorRepository;
import mk.ukim.finki.labb.repository.BookRepository;
import mk.ukim.finki.labb.repository.BookStoreRepository;
import mk.ukim.finki.labb.service.BookService;
import mk.ukim.finki.labb.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookStoreRepository bookStoreRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository,BookStoreRepository bookStoreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookStoreRepository=bookStoreRepository;
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

    @Override
    public void deleteByIsbn(String isbn) {
        bookRepository.deleteBook(isbn);
    }

    @Override
    public Optional<Book> saveBook(String isbn, String title, String genre, int year,Long bookStore) {
        BookStore b=this.bookStoreRepository.findById(bookStore).orElseThrow(()->new RuntimeException());
        return this.bookRepository.saveBook(isbn,title,genre,year,b);
    }
}
