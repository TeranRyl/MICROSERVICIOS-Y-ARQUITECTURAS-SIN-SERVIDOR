package edu.microservicios.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;

// Entidad de MongoDB que representa un post
@MongoEntity(database = "arepquarkus", collection = "posts")
public class Post {

    private String id;
    private String message;
    private String user;

    // Constructor con parámetros para inicializar la entidad
    public Post(String id, String message, String user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }

    // Constructor sin parámetros necesario para el uso de Panache
    public Post() {
    }

    // Métodos de acceso para obtener y establecer el ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Métodos de acceso para obtener y establecer el usuario
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    // Métodos de acceso para obtener y establecer el mensaje
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
