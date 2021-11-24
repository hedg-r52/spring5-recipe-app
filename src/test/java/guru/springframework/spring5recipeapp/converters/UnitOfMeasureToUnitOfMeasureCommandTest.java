package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;
import guru.springframework.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 24.11.2021
 */
class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long ID_VALUE = 1L;

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    void convert() {
        // given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(ID_VALUE);
        uom.setDescription(DESCRIPTION);

        // when
        UnitOfMeasureCommand uomc = converter.convert(uom);

        // then
        assertNotNull(uomc);
        assertEquals(ID_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }
}
