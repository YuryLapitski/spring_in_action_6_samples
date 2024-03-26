package tacos.entity;

import lombok.Data;

@Data
public class IngredientRef {

    private final String ingredient;
    private final long tacoId;
    private final int tacoKey;
}
