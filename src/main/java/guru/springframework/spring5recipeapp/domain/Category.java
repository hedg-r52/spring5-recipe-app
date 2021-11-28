package guru.springframework.spring5recipeapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 16.11.2021
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = "recipes")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
    private String description;

}
