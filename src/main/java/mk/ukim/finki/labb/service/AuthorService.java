package mk.ukim.finki.labb.service;

import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    Author findById(Long id);
    Optional<Author> saveAuthor(String name,String surname,String bio);
}
