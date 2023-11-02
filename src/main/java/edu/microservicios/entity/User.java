package edu.microservicios.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

// Entidad de MongoDB que representa un usuario
@MongoEntity(database = "arepquarkus", collection = "users")
public class User extends PanacheMongoEntity {

    // Identificador único del usuario
    private String id;

    // Nombre del usuario
    private String name;

    // Dirección de correo electrónico del usuario
    private String email;

    // Contraseña del usuario
    private String password;

    // Constructor con parámetros para inicializar la entidad
    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Constructor sin parámetros necesario para el uso de Panache
    public User() {
    }

    // Método de acceso para obtener el ID del usuario
    public String getId() {
        return id;
    }

    // Método de acceso para establecer el ID del usuario
    public void setId(String id) {
        this.id = id;
    }

    // Método de acceso para obtener el nombre del usuario
    public String getName() {
        return name;
    }

    // Método de acceso para establecer el nombre del usuario
    public void setName(String name) {
        this.name = name;
    }

    // Método de acceso para obtener la dirección de correo electrónico del usuario
    public String getEmail() {
        return email;
    }

    // Método de acceso para establecer la dirección de correo electrónico del usuario
    public void setEmail(String email) {
        this.email = email;
    }

    // Método de acceso para obtener la contraseña del usuario
    public String getPassword() {
        return password;
    }

    // Método de acceso para establecer la contraseña del usuario
    public void setPassword(String password) {
        this.password = password;
    }
}
