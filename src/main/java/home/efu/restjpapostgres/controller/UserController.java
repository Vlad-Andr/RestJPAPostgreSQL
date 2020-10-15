package home.efu.restjpapostgres.controller;

import home.efu.restjpapostgres.model.User;
import home.efu.restjpapostgres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/admin/add")
    public ResponseEntity addUser(@RequestBody User user) {
        userService.addNewUser(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("user with id: " + id + " was deleted");
    }

    @GetMapping("/admin/getAll")
    public ResponseEntity<List<User>> getAll() {
        List<User> all = userService.allUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(all);
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody User newUser) {
        userService.updateUser(id, newUser);
        return ResponseEntity.status(HttpStatus.OK)
                .body("user with id: " + id + " was updated");
    }

    @GetMapping("/user/get/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }
}
