package guru.springframework.spring5recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 24.11.2021
 */
@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private Long id;
    private String description;
}
