package org.acme.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.Author;
import org.acme.service.AuthorService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.annotations.Param;


@Path("/author")
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    AuthorService authorService;

    @GET
    @Path("/")
    public String test(){
        return "Hello from author controller";
    }


    @POST
    @Path("/add")
    public Author addNewAuthor(@RequestBody Author newAuthor){
        return authorService.addnewAuthor(newAuthor);
    }

    @PATCH
    @Path("/update/{id}")
    public Author updateAuthor(@RequestBody Author auth, @PathParam("id") long id){
        return authorService.updateAuthor(auth, id);
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteAuthor(@PathParam("id") long id){
        return Response.ok(authorService.deleteAuthor(id)).build();
    }

    @GET
    @Path("/get")
    public Response getAuthors(@QueryParam("age") int age){
        return Response.ok(authorService.getAuthorsByAge(age)).build();
    }


}
