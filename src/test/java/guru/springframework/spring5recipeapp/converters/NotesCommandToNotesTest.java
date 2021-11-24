package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commands.NotesCommand;
import guru.springframework.spring5recipeapp.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 24.11.2021
 */
class NotesCommandToNotesTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";

    NotesCommandToNotes converter;

    @BeforeEach
    void setUp() {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    void convert() {
        // given
        NotesCommand command = new NotesCommand();
        command.setId(ID_VALUE);
        command.setRecipeNotes(RECIPE_NOTES);

        // when
        Notes notes = converter.convert(command);

        // then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }
}
