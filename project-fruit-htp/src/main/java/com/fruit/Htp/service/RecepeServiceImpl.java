package com.fruit.Htp.service;

import com.fruit.Htp.model.Recipe;
import com.fruit.Htp.model.User;
import com.fruit.Htp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecepeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;


    @Override
    public Recipe createRecipe(Recipe recipe, User user) {

        Recipe createRecipe = new Recipe();
        createRecipe.setTitle(recipe.getTitle());
        createRecipe.setImage(recipe.getImage());
        createRecipe.setDescription(recipe.getDescription());
        createRecipe.setUser(user);
        createRecipe.setCreateAt(LocalDateTime.now());
        return recipeRepository.save(createRecipe);
    }

    @Override
    public Recipe findRecipeById(Long id) throws Exception {
        Optional<Recipe> optional = recipeRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        throw  new Exception("recipe not found with it " + id);
    }

    @Override
    public void deleteRecipe(Long id) throws Exception {
        findRecipeById(id);
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long id) throws Exception {
       Recipe oldRecipe = findRecipeById(id);
            if(recipe.getTitle()!= null) {
                oldRecipe.setTitle(recipe.getTitle());
            }
            if(recipe.getImage()!= null) {
                oldRecipe.setImage(recipe.getImage());
            }
            if(recipe.getDescription()!= null) {
                oldRecipe.setDescription(recipe.getDescription());
            }
        return recipeRepository.save(oldRecipe);
    }

    @Override
    public List<Recipe> findAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe likeRecipe(Long recipeId, User user) throws Exception {
        Recipe recipe = findRecipeById(recipeId);
        if(recipe.getLikes().contains(user.getId())) {
            recipe.getLikes().remove(user.getId());
        }
        else {
            recipe.getLikes().add(user.getId());
        }
        return recipeRepository.save(recipe);
    }
}
