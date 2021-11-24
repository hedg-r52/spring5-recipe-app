package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commands.RecipeCommand;
import guru.springframework.spring5recipeapp.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 24.11.2021
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(
            CategoryCommandToCategory categoryConverter,
            IngredientCommandToIngredient ingredientConverter,
            NotesCommandToNotes notesConverter
    ) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (Objects.nonNull(source)) {
            final Recipe recipe = new Recipe();
            recipe.setId(source.getId());
            recipe.setCookTime(source.getCookTime());
            recipe.setPrepTime(source.getPrepTime());
            recipe.setDescription(source.getDescription());
            recipe.setDifficulty(source.getDifficulty());
            recipe.setServings(source.getServings());
            recipe.setSource(source.getSource());
            recipe.setDirections(source.getDirections());
            recipe.setUrl(source.getUrl());
            recipe.setNotes(notesConverter.convert(source.getNotes()));

            if (Objects.nonNull(source.getCategories()) && source.getCategories().size() > 0) {
                source.getCategories()
                        .forEach(category -> recipe.getCategories().add(categoryConverter.convert(category)));
            }

            if (Objects.nonNull(source.getIngredients()) && source.getIngredients().size() > 0) {
                source.getIngredients()
                        .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
            }

            return recipe;
        }
        return null;
    }
}
