package mk.ukim.finki.labb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
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

    public Book(String isbn, String title, String genre, int year,BookStore bookStore) {
        this.id=(long)(Math.random()*1000);
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = new ArrayList<>();
        this.bookStore=bookStore;
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

    public Long getId() {
        return id;
    }

    public BookStore getBookStore() {
        return bookStore;
    }

    public String authorsToString(){
        if(authors.size()>0) {
            StringBuilder sb = new StringBuilder();
            for (Author a : authors) {
                sb.append(a).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }else{
            return "";
        }
    }
}
