package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commands.CategoryCommand;
import guru.springframework.spring5recipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 24.11.2021
 */
class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";

    CategoryCommandToCategory converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryCommandToCategory();
    }

    @Test
    void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert() throws Exception {
        // given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        // when
        Category category = converter.convert(categoryCommand);

        // then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}
