package menufact.Builder;

import ingredients.Ingredient;
import java.util.Map;
import java.util.HashMap;

public class Recette {
    private Map<Ingredient, Double> ingredients;

    public Recette() {
        ingredients = new HashMap<>();
    }

    public void addIngredient(Ingredient ingredient, double quantity) {
        ingredients.put(ingredient, quantity);
    }

    public Map<Ingredient, Double> getIngredients() {
        return ingredients;
    }
}

