package mk.ukim.finki.labb.service.impl;

import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.model.BookStore;
import mk.ukim.finki.labb.model.exceptions.NonValidIdException;
import mk.ukim.finki.labb.repository.AuthorRepository;
import mk.ukim.finki.labb.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(NonValidIdException::new);
    }
    @Override
    public Optional<Author> saveAuthor(String name,String surname,String bio) {
        return this.authorRepository.saveAuthor(name,surname,bio);
    }
}
