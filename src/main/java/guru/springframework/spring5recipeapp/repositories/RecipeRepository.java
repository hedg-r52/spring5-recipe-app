package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 16.11.2021
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
