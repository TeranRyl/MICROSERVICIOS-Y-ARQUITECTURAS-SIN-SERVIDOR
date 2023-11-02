package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Esta anotación indica que esta clase representa un recurso JAX-RS y la ruta base es "/hello"
@Path("/hello")
public class GreetingResource {

    // Esta anotación indica que este método responde a peticiones HTTP GET
    @GET
    
    // Esta anotación indica que el método produce texto plano como tipo de medio de respuesta
    @Produces(MediaType.TEXT_PLAIN)
    
    // Este método devuelve la cadena "Hello" como respuesta a las solicitudes GET
    public String hello() {
        return "Hello";
    }
}
