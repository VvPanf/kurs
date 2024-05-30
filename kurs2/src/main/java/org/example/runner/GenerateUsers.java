package org.example.runner;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GenerateUsers implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = List.of(
                new User(UUID.randomUUID().toString(), "admin", "admin"),
                new User(UUID.randomUUID().toString(), "qwe", "123")
        );

        for (User user : users) {
            userService.addUser(user);
        }
    }
}
