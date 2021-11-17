package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 17.11.2021
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
