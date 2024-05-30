package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Recipe;
import org.example.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class RecipeService {
    @Autowired
    private RecipeRepo recipeRepo;

    public List<Recipe> findAllByUserId(String userId) {
        log.info("Show all recipes for user: {}", userId);
        return recipeRepo.findAllByUserId(userId);
    }

    public Recipe findById(String id) {
        return recipeRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Recipe not found"));
    }

    public Recipe addRecipe(Recipe recipe) {
        Recipe result = recipeRepo.save(recipe);
        log.info("Added a new recipe: {}", result);
        return result;
    }

    public void deleteById(String id) {
        log.info("Removed recipe by id: {}", id);
        recipeRepo.deleteById(id);
    }
}
