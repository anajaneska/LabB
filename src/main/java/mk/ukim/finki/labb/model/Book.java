package mk.ukim.finki.labb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
//@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private String genre;
    private int year;
    private List<Author> authors;
    private Long id;

    private BookStore bookStore;

    public Book(String isbn, String title, String genre, int year, List<Author> authors) {
        this.id=(long)(Math.random()*1000);
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author a){
        this.authors.add(a);
    }

}
