package org.example.repo;

import jakarta.annotation.Resource;
import org.example.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private static final String KEY = "users";

    @Resource(name="redisTemplate")
    private HashOperations<String, String, User> hashOps;

    public User getByUsername(String username) {
        return hashOps.get(KEY, username);
    }

    public boolean save(User user) {
        return hashOps.putIfAbsent(KEY, user.getUsername(), user);
    }
}
