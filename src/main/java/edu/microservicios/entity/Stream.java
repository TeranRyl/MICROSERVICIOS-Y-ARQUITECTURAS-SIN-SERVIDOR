package edu.microservicios.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.ArrayList;

// Entidad de MongoDB que representa un stream de tweets
@MongoEntity(database = "arepquarkus", collection = "stream")
public class Stream {

    // Lista de tweets en el stream
    private ArrayList<String> posts = new ArrayList<>();

    // Constructor con parámetros para inicializar la entidad
    public Stream(ArrayList<String> posts) {
        this.posts = posts;
    }

    // Constructor sin parámetros necesario para el uso de Panache
    public Stream() {
    }

    // Método de acceso para obtener la lista de tweets
    public ArrayList<String> getPosts() {
        return posts;
    }

    // Método de acceso para establecer la lista de tweets
    public void setTweets(ArrayList<String> posts) {
        this.posts = posts;
    }

 
}
