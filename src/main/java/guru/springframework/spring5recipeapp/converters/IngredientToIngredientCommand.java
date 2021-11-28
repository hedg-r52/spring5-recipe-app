package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commands.IngredientCommand;
import guru.springframework.spring5recipeapp.domain.Ingredient;
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
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (Objects.nonNull(source)) {
            final IngredientCommand ingredientCommand = new IngredientCommand();
            ingredientCommand.setId(source.getId());
            ingredientCommand.setAmount(source.getAmount());
            ingredientCommand.setDescription(source.getDescription());
            ingredientCommand.setUnitOfMeasure(uomConverter.convert(source.getUom()));
            if (Objects.nonNull(source.getRecipe())) {
                ingredientCommand.setRecipeId(source.getRecipe().getId());
            }
            return ingredientCommand;
        }
        return null;
    }
}
