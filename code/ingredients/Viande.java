package ingredients;

import ingredients.etat.EtatIngredient;

public class Viande extends Ingredient{
    public Viande(String nom, EtatIngredient etat, double quantite) {
        super(nom, TypeIngredient.VIANDE, etat, quantite);
    }
}
/**
 * Creates a new Viande object with the given name, state, and quantity.
 * The type of ingredient is set to TypeIngredient.VIANDE.
 * @param nom The name of the ingredient.
 * @param etat The state of the ingredient.
 * @param quantite The quantity of the ingredient.
 */