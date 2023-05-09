package menufact.Builder;

import ingredients.Ingredient;
import java.util.Map;
import java.util.HashMap;

public class Recette {
    private Map<Ingredient, Double> ingredients;
    /**
     * Constructs a new recipe object with an empty map of ingredients.
     */
    public Recette() {
        ingredients = new HashMap<>();
    }
    /**
     * Adds an ingredient with its quantity to the recipe.
     * @param ingredient the ingredient to add
     * @param quantity the quantity of the ingredient to add
     */
    public void addIngredient(Ingredient ingredient, double quantity) {
        ingredients.put(ingredient, quantity);
    }
    /**
     * Returns the map of ingredients and their quantities for the recipe.
     * @return the map of ingredients and their quantities for the recipe
     */
    public Map<Ingredient, Double> getIngredients() {
        return ingredients;
    }
}

