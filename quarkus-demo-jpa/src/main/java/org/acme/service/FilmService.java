package org.acme.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.acme.model.Film;
import org.acme.model.Film$;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class FilmService {
    @Inject
    JPAStreamer jpaStreamer;

    public List<Film>getAllFilms(){
        return jpaStreamer.stream(Film.class).limit(5).toList();
    }

    public Optional<Film>getFilmsById(int id){
        return jpaStreamer.stream(Film.class).filter(Film$.filmId.equal(id)).findFirst();
    }

    public long getFilmsCountByRating(String ratings){
        return jpaStreamer.stream(Film.class)
                .filter(Film$.rating.equal(ratings))
                .count();
    }

//    public Film addNewFilm(Film newFilm){
//        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sakila");
//    }
}
