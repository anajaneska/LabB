package mk.ukim.finki.labb.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class DataHolder {
    public static List<Author> authors=new ArrayList<>();
    public static List<Book> books=new ArrayList<>();

    @PostConstruct
    public void init(){
        authors.add(new Author(1L,"Stephen","King","Stephen King, the \"Master of Horror,\" is an acclaimed American author who has written numerous best-selling novels, including \"The Shining,\" \"It,\" and \"Carrie,\" known for his chilling and suspenseful storytelling."));
        authors.add(new Author(2L,"Jane","Austen","Jane Austen, a renowned English novelist from the 19th century, is celebrated for her novels, including \"Pride and Prejudice\" and \"Sense and Sensibility,\" which explore themes of love, society, and relationships in Regency-era England."));
        authors.add(new Author(3L,"Neil","Gaiman","Neil Gaiman is a prolific British-American author renowned for his diverse and imaginative works spanning fantasy, graphic novels, and contemporary fiction."));
        authors.add(new Author(4L,"Aldous","Huxley","Aldous Huxley, a British author, is best known for his dystopian classic \"Brave New World,\" which explores themes of technology, conformity, and individuality in a future society."));
        authors.add(new Author(5L,"Agatha","Christie","Agatha Christie, the \"Queen of Mystery,\" was an English author famous for her detective fiction, including iconic characters like Hercule Poirot and Miss Marple, and timeless classics such as \"Murder on the Orient Express.\""));

        books.add(new Book("1",
                "The Shining",
                "horror ",
                1977,
                authors.stream().filter(i->i.getId().equals(1L)).collect(Collectors.toList())));
        books.add(new Book("2",
                "Pride and Prejudice",
                "classic literature",
                1813,
                authors.stream().filter(i->i.getId().equals(2L)).collect(Collectors.toList())));
        books.add(new Book("3",
                "Good Omens",
                "fantasy",
                1990,
                authors.stream().filter(i->i.getId().equals(3L)).collect(Collectors.toList())));
        books.add(new Book("4",
                "Island",
                "science fiction",
                1962,
                authors.stream().filter(i->i.getId().equals(4L)).collect(Collectors.toList())));
        books.add(new Book("5",
                "Murder on the Orient Express",
                "detective fiction",
                1934,
                authors.stream().filter(i->i.getId().equals(5L)).collect(Collectors.toList())));
    }
}
