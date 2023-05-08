package inventaire;

import ingredients.IngredientsAuMenu;

import java.util.HashMap;
import java.util.Map;

public class Inventaire {
    private static Inventaire inventaire;
    private Map<IngredientsAuMenu,Integer> ingredients = new HashMap<>();

    private Inventaire() {
    }

    /**
     * @return une instance de l'ingredients.inventaire (toujours la même)
     */
    public static Inventaire getInventaire() {
        if (inventaire == null)
            inventaire = new Inventaire();
        return inventaire;
    }

    /**
     * @param ingredient est l'ingredient a ajoute
     * @param quantity est la quantite de l'ingredient ajoute
     */
    public void addIngredient(IngredientsAuMenu ingredient, Integer quantity) {
        this.ingredients.put(ingredient,quantity);
    }

    /**
     * @return l'ingredients.inventaire des ingredients et la quantite de chacun
     */
    @Override
    public String toString() {
        String text = "";
        for (Map.Entry<IngredientsAuMenu, Integer> entry: ingredients.entrySet()) {
            text += (entry.getKey() + ", quantite : " + entry.getValue()) +
                    "\n";
        }
        return text;
    }

    public Map<IngredientsAuMenu, Integer> getIngredients() { return ingredients; }
}