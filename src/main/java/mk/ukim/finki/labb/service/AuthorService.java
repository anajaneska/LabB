package mk.ukim.finki.labb.service;

import mk.ukim.finki.labb.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> listAuthors();
    Author findById(Long id);
}
