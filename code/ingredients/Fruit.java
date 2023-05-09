package ingredients;

import ingredients.etat.EtatIngredient;

public class Fruit extends Ingredient {
    public Fruit(String nom, EtatIngredient etat, double quantite) {
        super(nom,TypeIngredient.FRUIT, etat, quantite);
    }
}

/**
 * Creates a new Fruit object with the given name, state, and quantity.
 * The type of ingredient is set to TypeIngredient.FRUIT.
 * @param nom The name of the fruit.
 * @param etat The state of the fruit.
 * @param quantite The quantity of the fruit.
 */
