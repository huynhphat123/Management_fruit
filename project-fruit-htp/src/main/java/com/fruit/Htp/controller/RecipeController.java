package com.fruit.Htp.controller;

import com.fruit.Htp.model.Recipe;
import com.fruit.Htp.model.User;
import com.fruit.Htp.service.RecipeService;
import com.fruit.Htp.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserSerivce userSerivce;

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe,
                               @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userSerivce.findUserByJwt(jwt);

        Recipe createRecipe = recipeService.createRecipe(recipe,user);
        return createRecipe;
    }

    @GetMapping()
    public List<Recipe> getAllRecipe() throws Exception {
         List<Recipe> recipes = recipeService.findAllRecipe();
        return recipes;
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {
        Recipe updatedRecipe = recipeService.updateRecipe(recipe,id);
        return updatedRecipe;
    }

    @DeleteMapping("/{recipeId}")
    public String DeleteRecipe(@PathVariable Long recipeId) throws Exception {
        recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";
    }

    @PutMapping("/{id}/like")
    public Recipe likeRecipe(@RequestHeader("Authorization") String jwt,
                             @PathVariable Long id) throws Exception {
        User user = userSerivce.findUserByJwt(jwt);
        Recipe likeRecipe = recipeService.likeRecipe(id,user);
        return likeRecipe;
    }

}

