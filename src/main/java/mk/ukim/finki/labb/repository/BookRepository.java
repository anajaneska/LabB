package mk.ukim.finki.labb.repository;

import mk.ukim.finki.labb.bootstrap.DataHolder;
import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    public List<Book> findAll(){
        return DataHolder.books;
    }
    public Optional<Book> findByIsbn(String isbn){
        return DataHolder.books.stream().filter(i->i.getIsbn().equals(isbn)).findFirst();
    }
    public Author addAuthorToBook(Author author, Book book){
        DataHolder.books.removeIf(i->i.equals(book));
        book.addAuthor(author);
        DataHolder.books.add(book);
        return author;
    }
    public void deleteBook(String isbn){
        DataHolder.books.removeIf(i->i.getIsbn().equals(isbn));
    }
    public Optional<Book> saveBook(String isbn, String title, String genre, int year,BookStore bookStore){
        DataHolder.books.removeIf(i->i.getIsbn().equals(isbn));
        Book newBook=new Book(isbn,title,genre,year,bookStore);
        DataHolder.books.add(newBook);
        return Optional.of(newBook);
    }
}
