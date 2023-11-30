package mk.ukim.finki.labb.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.labb.model.Author;
import mk.ukim.finki.labb.model.Book;
import mk.ukim.finki.labb.model.BookStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class DataHolder {
    public static List<Author> authors=new ArrayList<>();
    public static List<Book> books=new ArrayList<>();
    public static List<BookStore> bookStores=new ArrayList<>();

    @PostConstruct
    public void init(){
        Author StevenKing=new Author(1L,"Stephen","King","Stephen King, the \"Master of Horror,\" is an acclaimed American author who has written numerous best-selling novels, including \"The Shining,\" \"It,\" and \"Carrie,\" known for his chilling and suspenseful storytelling.");
        Author JaneAusten=new Author(2L,"Jane","Austen","Jane Austen, a renowned English novelist from the 19th century, is celebrated for her novels, including \"Pride and Prejudice\" and \"Sense and Sensibility,\" which explore themes of love, society, and relationships in Regency-era England.");
        Author NeilGaiman=new Author(3L,"Neil","Gaiman","Neil Gaiman is a prolific British-American author renowned for his diverse and imaginative works spanning fantasy, graphic novels, and contemporary fiction.");
        Author AldousHuxley=new Author(4L,"Aldous","Huxley","Aldous Huxley, a British author, is best known for his dystopian classic \"Brave New World,\" which explores themes of technology, conformity, and individuality in a future society.");
        Author AgathaChristie=new Author(5L,"Agatha","Christie","Agatha Christie, the \"Queen of Mystery,\" was an English author famous for her detective fiction, including iconic characters like Hercule Poirot and Miss Marple, and timeless classics such as \"Murder on the Orient Express.\"");

        BookStore Literatura=new BookStore("Literatura","Skopje"," XCVJ+J58, Macedonia St");
        BookStore Tri=new BookStore("Tri","Skopje","City Trade Center");
        BookStore Babuk=new BookStore("Babuk","Bitola","Ruzveltova 24");
        BookStore AkademskaKniga=new BookStore("Akademska kniga","Skopje","Porta Bunjakovec, Blvd. Partizanski Odredi 23");
        BookStore Prosveta=new BookStore("Prosveta","Ohrid"," St Clement of Ohrid 25A");

        Book TheShining=new Book("1", "The Shining", "horror ", 1977, Literatura);
        Book PrideAndPrejudice=new Book("2", "Pride and Prejudice", "classic literature", 1813, AkademskaKniga);
        Book GoodOmens=new Book("3", "Good Omens", "fantasy", 1990, Babuk);
        Book Island=new Book("4", "Island", "science fiction", 1962, Tri);
        Book MurderOnTheOrientExpress=new Book("5", "Murder on the Orient Express", "detective fiction", 1934, Prosveta);

        authors.add(StevenKing);
        authors.add(JaneAusten);
        authors.add(NeilGaiman);
        authors.add(AldousHuxley);
        authors.add(AgathaChristie);

        bookStores.add(Literatura);
        bookStores.add(Tri);
        bookStores.add(Babuk);
        bookStores.add(AkademskaKniga);
        bookStores.add(Prosveta);

        TheShining.addAuthor(StevenKing);
        PrideAndPrejudice.addAuthor(JaneAusten);
        GoodOmens.addAuthor(NeilGaiman);
        Island.addAuthor(AldousHuxley);
        MurderOnTheOrientExpress.addAuthor(AgathaChristie);

        books.add(TheShining);
        books.add(PrideAndPrejudice);
        books.add(GoodOmens);
        books.add(Island);
        books.add(MurderOnTheOrientExpress);
    }
}
