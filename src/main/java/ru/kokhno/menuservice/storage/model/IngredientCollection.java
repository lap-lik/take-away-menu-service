package ru.kokhno.menuservice.storage.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCollection {

    private List<Ingredient> ingredients;
}
