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
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (Objects.nonNull(source)) {
            final UnitOfMeasure uoc = new UnitOfMeasure();
            uoc.setId(source.getId());
            uoc.setDescription(source.getDescription());
            return uoc;
        }
        return null;
    }
}
