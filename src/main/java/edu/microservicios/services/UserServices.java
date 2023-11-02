package edu.microservicios.services;

import edu.microservicios.entity.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserServices {

    List<User> getAllUsers();

    void crear(User usuario);

    User buscarPorId(ObjectId id);

    Boolean login(User user);
}
