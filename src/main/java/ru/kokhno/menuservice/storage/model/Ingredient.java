package ru.kokhno.menuservice.storage.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    private String name;
    private int calories;
}
