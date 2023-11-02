package edu.microservicios.controller;

import edu.microservicios.entity.User;
import edu.microservicios.services.UserServices;
import org.bson.types.ObjectId;

import edu.microservicios.cognito.CognitoClient;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// Controlador para gestionar operaciones relacionadas con los usuarios
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    // Inyección de dependencias para los servicios de usuarios
    @Inject
    UserServices userServices;

    // Cliente de Cognito para gestionar la autenticación
    CognitoClient cognitoClient = new CognitoClient();

    // Método para obtener todos los usuarios
    @GET
    public List<User> getAllUsers(){
       return userServices.getAllUsers();
    }

    // Método para realizar el inicio de sesión de un usuario y obtener tokens de Cognito
    @POST
    @Path("login")
    public Response login(User usuario) {
        // Verificar las credenciales del usuario utilizando el servicio de usuarios
        if(userServices.login(usuario)) {
            // Devolver una respuesta exitosa junto con los tokens de Cognito
            return Response.status(Response.Status.ACCEPTED).entity(cognitoClient.login(usuario.getEmail(), usuario.getPassword())).build();
        }
        // Devolver una respuesta de error si las credenciales no son válidas
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

   
}
