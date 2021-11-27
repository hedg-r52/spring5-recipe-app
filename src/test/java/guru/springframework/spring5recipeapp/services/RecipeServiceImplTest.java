package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.commands.RecipeCommand;
import guru.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import guru.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import guru.springframework.spring5recipeapp.domain.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 20.11.2021
 */
class RecipeServiceImplTest {

    private static final Long ID_VALUE = 1L;
    private static final Long ID_TO_DELETE = 2L;
    private static final String DESCRIPTION = "description";

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this).close();
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipes() throws Exception {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void findById() {
        Recipe recipe = new Recipe();
        recipe.setId(ID_VALUE);
        recipe.setDescription(DESCRIPTION);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        Recipe savedRecipe = recipeService.findById(ID_VALUE);
        assertEquals(DESCRIPTION, savedRecipe.getDescription());
        verify(recipeRepository).findById(any());
    }

    @Test
    public void findCommandById() {
        Recipe recipe = new Recipe();
        recipe.setId(ID_VALUE);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        RecipeCommand command = new RecipeCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);

        when(recipeToRecipeCommand.convert(any(Recipe.class))).thenReturn(command);

        RecipeCommand savedCommand = recipeService.findCommandById(ID_VALUE);
        assertNotNull(savedCommand);
        assertEquals(DESCRIPTION, savedCommand.getDescription());
        verify(recipeRepository).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void saveRecipeCommand() {
        Recipe recipe = new Recipe();
        recipe.setId(ID_VALUE);
        recipe.setDescription(DESCRIPTION);

        RecipeCommand command = new RecipeCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);

        when(recipeCommandToRecipe.convert(any(RecipeCommand.class))).thenReturn(recipe);
        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe);
        when(recipeToRecipeCommand.convert(any(Recipe.class))).thenReturn(command);

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        assertNotNull(savedCommand);
        assertEquals(DESCRIPTION, savedCommand.getDescription());
        verify(recipeToRecipeCommand).convert(any());
        verify(recipeCommandToRecipe).convert(any());
        verify(recipeRepository).save(any());

    }

    @Test
    public void testDeleteById() throws Exception {
        recipeService.deleteById(ID_TO_DELETE);
        verify(recipeRepository).deleteById(anyLong());
    }

}