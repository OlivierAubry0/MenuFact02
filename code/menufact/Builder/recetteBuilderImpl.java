package menufact.Builder;

import ingredients.Ingredient;
import java.util.Map;
import java.util.HashMap;

public class RecetteBuilderImpl implements RecetteBuilder {
    private Map<Ingredient, Integer> ingredients = new HashMap<>();

    @Override
    public RecetteBuilder addIngredient(Ingredient ingredient, int quantite) {
        ingredients.put(ingredient, quantite);
        return this;
    }

    @Override
    public Recette build() {
        return new Recette(ingredients);
    }
}

