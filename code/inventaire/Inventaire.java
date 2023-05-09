package inventaire;

import ingredients.Ingredient;
import ingredients.TypeIngredient;
import ingredients.IngredientsAuMenu;
import ingredients.etat.EtatIngredient;
import menufact.Builder.Recette;

import java.util.HashMap;
import java.util.Map;

public class Inventaire {
    private static Inventaire inventaire;
    private Map<Ingredient, Double> ingredients = new HashMap<>();
    private IngredientsAuMenu ingredientsAuMenu = new IngredientsAuMenu();

    private Inventaire() {
    }

    public static Inventaire getInventaire() {
        if (inventaire == null)
            inventaire = new Inventaire();
        return inventaire;
    }

    public void addIngredient(String nom, TypeIngredient type, EtatIngredient etat, double quantite) {
        Ingredient ingredient = ingredientsAuMenu.getIngredient(nom,quantite, type, etat);
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0.0) + quantite);
    }

    public void removeIngredient(String nom, TypeIngredient type, EtatIngredient etat, double quantite) {
        Ingredient ingredient = ingredientsAuMenu.getIngredient(nom, quantite, type, etat);
        Double currentQuantity = ingredients.get(ingredient);
        if (currentQuantity == null || currentQuantity < quantite) {
            throw new IllegalArgumentException("Not enough ingredient in inventory.");
        }
        ingredients.put(ingredient, currentQuantity - quantite);
    }

    public boolean hasSufficientIngredients(Recette recette) {
        for (Map.Entry<Ingredient, Double> entry : recette.getIngredients().entrySet()) {
            Ingredient ingredient = entry.getKey();
            Double requiredQuantity = entry.getValue();
            Double availableQuantity = ingredients.get(ingredient);
            if (availableQuantity == null || availableQuantity < requiredQuantity) {
                return false;
            }
        }
        return true;
    }
}
