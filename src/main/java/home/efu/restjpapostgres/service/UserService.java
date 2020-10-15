package home.efu.restjpapostgres.service;

import home.efu.restjpapostgres.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addNewUser(User user);

    List<User> allUsers();

    void deleteUser(Long id);

    void updateUser(Long id, User user);

    Optional<User> getUserById(Long id);
}
