package guru.springframework.spring5recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 24.11.2021
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
}

