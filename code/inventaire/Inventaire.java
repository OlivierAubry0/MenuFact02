package inventaire;

import ingredients.IngredientsAuMenu;

import java.util.HashMap;
import java.util.Map;

public class Inventaire {
    private static Inventaire inventaire;
    private Map<IngredientsAuMenu,Integer> ingredients = new HashMap<>();

    private Inventaire() {
    }

    public class InsufficientQuantityException extends Exception {
        public InsufficientQuantityException(String message) {
            super(message);
        }
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

    public void removeIngredient(IngredientsAuMenu ingredient, Integer quantityToRemove) throws InsufficientQuantityException {
        Integer currentQuantity = ingredients.get(ingredient);

        if (currentQuantity == null) {
            throw new InsufficientQuantityException("L'ingrédient " + ingredient + " n'est pas présent dans l'inventaire.");
        }

        if (currentQuantity >= quantityToRemove) {
            ingredients.put(ingredient, currentQuantity - quantityToRemove);
        } else {
            throw new InsufficientQuantityException("La quantité à retirer (" + quantityToRemove + ") est supérieure à la quantité disponible (" + currentQuantity + ").");
        }
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