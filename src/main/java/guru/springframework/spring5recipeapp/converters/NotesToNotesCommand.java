package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commands.NotesCommand;
import guru.springframework.spring5recipeapp.domain.Notes;
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
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (Objects.nonNull(source)) {
            final NotesCommand notesCommand = new NotesCommand();
            notesCommand.setId(source.getId());
            notesCommand.setRecipeNotes(source.getRecipeNotes());
            return notesCommand;
        }
        return null;
    }
}
