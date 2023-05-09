package ingredients;

import ingredients.etat.IngredientEtat;

public class Fruit extends Ingredient {
    public Fruit(String nom, IngredientEtat etat, double quantite) {
        super(nom,TypeIngredient.FRUIT, etat, quantite);
    }
}

