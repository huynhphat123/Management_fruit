package com.fruit.Htp.repository;

import com.fruit.Htp.model.Recipe;
import com.fruit.Htp.service.RecipeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository <Recipe, Long> {

}
