package ingredients;

import ingredients.etat.EtatIngredient;

public class Legume extends Ingredient{
    public Legume(String nom, EtatIngredient etat, double quantite) {
        super(nom, TypeIngredient.LEGUME, etat, quantite);
    }
}
/**
 * Creates a new Laitier object with the given name, state, and quantity.
 * The type of ingredient is set to TypeIngredient.LAITIER.
 * @param nom The name of the ingredient.
 * @param etat The state of the ingredient.
 * @param quantite The quantity of the ingredient.
 */