package menufact.Builder;

import ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;


public class RecetteBuilder {
    private Recette recette;

    public RecetteBuilder() {
        recette = new Recette();
    }

    public RecetteBuilder addIngredient(Ingredient ingredient, double quantity) {
        recette.addIngredient(ingredient, quantity);
        return this;
    }

    public Recette build() {
        if (recette.getIngredients().isEmpty()) {
            throw new IllegalStateException("La recette doit contenir au moins un ingrédient.");
        }
        return recette;
    }
}


