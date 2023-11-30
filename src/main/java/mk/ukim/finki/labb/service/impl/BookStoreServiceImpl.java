package mk.ukim.finki.labb.service.impl;

import mk.ukim.finki.labb.model.BookStore;
import mk.ukim.finki.labb.repository.BookStoreRepository;
import mk.ukim.finki.labb.service.BookService;
import mk.ukim.finki.labb.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }
}
