package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.Film;
import org.acme.service.FilmService;
import org.jboss.logging.annotations.Param;

import java.util.List;
import java.util.Optional;

@Path("/film")
@Produces(MediaType.APPLICATION_JSON)
public class FilmController {
    @Inject
    FilmService filmService;

    @GET
    public Response getAllFilms(){
        List<Film>res = filmService.getAllFilms();
        return Response.ok(res).build();
    }

    @GET
    @Path("/get/{id}")
    public Response getFilmById(@PathParam("id") int id){
        Optional<Film>res = filmService.getFilmsById(id);
        return res.isPresent() ? Response.ok(res.get()).build() : Response
                .status(404, "No film found")
                .build();
    }

    @GET
    @Path("/get")
    public Response getFilmById(@QueryParam("rating") String rating){
        long res = filmService.getFilmsCountByRating(rating);
        return Response.ok(res).build();
    }
}
