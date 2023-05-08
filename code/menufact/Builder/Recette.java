package menufact.Builder;

import ingredients.Ingredient;
import java.util.Map;
import java.util.HashMap;

public class Recette {
    private Map<Ingredient, Integer> ingredients;

    public Recette(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public void afficherIngredients() {
        System.out.println("Liste des ingrédients pour cette recette :");
        for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(ingredient.getNom() + ": " + quantity);
        }
    }
}

