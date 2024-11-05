package org.acme.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.acme.model.Author;
import org.acme.model.Author$;

import java.util.*;

@ApplicationScoped
public class AuthorService {
    @Inject
    EntityManager entityManager;

    @Inject
    JPAStreamer streamer;


    @Transactional
    public Author addnewAuthor(Author auth){
//        entityManager.persist(auth);
        auth.persist();
        return auth;
    }

    @Transactional
    public Author updateAuthor(Author auth, long id){
        Optional<Author>temp = Author.findByIdOptional(Long.valueOf(id));
        if(temp.isPresent()){
            Author updatedAuthor = temp.get();
            if(auth.getAuth_name() != null) {
                temp.get().setAuth_name(auth.getAuth_name());
            }
            if(auth.getContact() != null){
                temp.get().setContact(auth.getContact());
            }
            return updatedAuthor;
        }
        throw new RuntimeException("Cannot find this particular author");
    }

    @Transactional
    public Author deleteAuthor(long id){
        Optional<Author>deletedAuthor = Author.findByIdOptional(id);
        if(deletedAuthor.isPresent()){
            Author res = deletedAuthor.get();
            Author.deleteById(id);
            return res;
        }
        throw new RuntimeException("Author not found with ID: " + id);
    }

    public List<Author>getAuthorsByAge(int age){
        List<Author>res = streamer.stream(Author.class)
                .filter(Author$.age.equal(age))
                .toList();
        if(!res.isEmpty()){
            return res;
        }
        throw new RuntimeException("No authors found");
    }

}
