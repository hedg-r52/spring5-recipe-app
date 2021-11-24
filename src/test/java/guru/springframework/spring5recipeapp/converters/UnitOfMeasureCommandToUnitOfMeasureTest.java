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
class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long ID_VALUE = 1L;

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void convert() {
        // given
        UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
        uomc.setId(ID_VALUE);
        uomc.setDescription(DESCRIPTION);

        // when
        UnitOfMeasure uom = converter.convert(uomc);

        // then
        assertNotNull(uom);
        assertEquals(ID_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}
