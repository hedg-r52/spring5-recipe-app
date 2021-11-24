package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commands.UnitOfMeasureCommand;
import guru.springframework.spring5recipeapp.domain.UnitOfMeasure;
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
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (Objects.nonNull(source)) {
            final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
            uomc.setId(source.getId());
            uomc.setDescription(source.getDescription());
            return uomc;
        }
        return null;
    }
}
