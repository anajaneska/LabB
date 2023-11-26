package mk.ukim.finki.labb.repository;

import mk.ukim.finki.labb.bootstrap.DataHolder;
import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
}
