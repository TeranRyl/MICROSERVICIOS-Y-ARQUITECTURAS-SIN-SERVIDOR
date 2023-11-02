package edu.microservicios.controller;

import edu.microservicios.entity.Post;
import edu.microservicios.entity.User;
import edu.microservicios.services.PostServices;
import edu.microservicios.services.UserServices;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// Controlador para gestionar operaciones relacionadas con los posts
@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostController {

    // Inyección de dependencias para los servicios de posts y usuarios
    @Inject
    PostServices postServices;

    @Inject
    UserServices userServices;

    // Método para obtener todos los posts
    @GET
    public List<Post> getAllPosts(){
        return postServices.getAllPosts();
    }

  
    // Método para crear un nuevo post
    @POST
    public Response createPost(Post post){
        // Convertir la cadena de ID a un objeto ObjectId
        ObjectId objectId = new ObjectId(post.getUser());
        // Buscar el usuario por ID
        User usuario = userServices.buscarPorId(objectId);
        // Manejar el caso en el que el usuario no existe
        if (usuario == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        // Crear el post
        postServices.createPost(post);
        // Devolver una respuesta con estado 201 (CREATED)
        return Response.status(Response.Status.CREATED).build();
    }

  
}
