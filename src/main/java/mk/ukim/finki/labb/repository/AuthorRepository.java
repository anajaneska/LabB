package mk.ukim.finki.labb.repository;

import mk.ukim.finki.labb.bootstrap.DataHolder;
import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    public List<Author> findAll(){
        return DataHolder.authors;
    }
    public Optional<Author> findById(Long id){
        return DataHolder.authors.stream().filter(i->i.getId().equals(id)).findFirst();
    }
    public Optional<Author> saveAuthor(String name,String surname,String bio){
        DataHolder.authors.removeIf(i->i.getName().equals(name) && i.getSurname().equals(surname));
        Author a=new Author(name,surname,bio);
        DataHolder.authors.add(a);
        return Optional.of(a);
    }
}
