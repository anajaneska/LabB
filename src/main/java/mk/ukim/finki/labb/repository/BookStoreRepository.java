package mk.ukim.finki.labb.repository;

import mk.ukim.finki.labb.bootstrap.DataHolder;
import mk.ukim.finki.labb.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookStoreRepository {
    public List<BookStore> findAll(){
        return DataHolder.bookStores;
    }
    public Optional<BookStore> findById(Long id){
        return DataHolder.bookStores.stream().filter(i->i.getId().equals(id)).findFirst();
    }
}
