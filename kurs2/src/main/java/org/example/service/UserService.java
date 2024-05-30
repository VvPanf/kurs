package org.example.service;

import org.example.model.User;
import org.example.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void addUser(User user) {
        userDao.save(user);
    }

    public String getUserId(User user) {
        User redisUser = userDao.getByUsername(user.getUsername());
        if (redisUser == null || !Objects.equals(redisUser.getPassword(), user.getPassword())) {
            return null;
        }
        return redisUser.getId();
    }
}
