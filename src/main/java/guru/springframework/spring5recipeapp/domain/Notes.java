package guru.springframework.spring5recipeapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Andrei Soloviev (hedg.r52@gmail.com).
 * date: 16.11.2021
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    private Recipe recipe;

    @Lob
    private String recipeNotes;

}
