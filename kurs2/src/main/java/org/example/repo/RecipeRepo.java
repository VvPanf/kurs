package org.example.repo;

import org.example.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepo extends MongoRepository<Recipe, String> {
    List<Recipe> findAllByUserId(String userId);
}
