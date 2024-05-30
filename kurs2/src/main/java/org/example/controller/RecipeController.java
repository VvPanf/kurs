package org.example.controller;

import org.example.model.Recipe;
import org.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    private String getMain() {
        return "redirect:/login";
    }

    @GetMapping("/recipes/{userId}")
    private String getRecipes(Model model, @PathVariable("userId") String userId) {
        List<Recipe> recipes = recipeService.findAllByUserId(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/add/{userId}")
    private String getAdd(Model model, @PathVariable("userId") String userId) {
        model.addAttribute("userId", userId);
        return "add";
    }

    @PostMapping("/add")
    private String postAdd(Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/recipes/" + recipe.getUserId();
    }

    @PostMapping("/delete/{userId}")
    private String postDelete(Model model, String id, @PathVariable("userId") String userId) {
        recipeService.deleteById(id);
        return getRecipes(model, userId);
    }
}
