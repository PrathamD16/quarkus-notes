package org.acme.model;
import jakarta.persistence.*;

@Entity
@Table(name = "film", schema = "sakila")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false, updatable = false, columnDefinition = "smallint(5)")
    private Integer filmId;

    @Column(name = "title", nullable = false, columnDefinition = "varchar(255)")
    private String title;

    @Column(name = "length", columnDefinition = "smallint(5)")
    private Integer length;

    @Column(name = "rating", columnDefinition = "enum('G','PG','PG-13','R','NC-17')")
    private String rating;

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getLength() {
        return length;
    }

    public String getRating() {
        return rating;
    }
}
