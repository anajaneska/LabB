package mk.ukim.finki.labb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    private Long id;
    private String name;
    private String surname;
    private String biography;

    public Author(String name, String surname, String biography) {
        this.id=(long)(Math.random()*1000);
        this.name = name;
        this.surname = surname;
        this.biography = biography;
    }

    @Override
    public String toString() {
        return name+" "+surname;
    }
}
