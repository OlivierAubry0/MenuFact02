package ingredients;

import ingredients.etat.EtatIngredient;
import ingredients.etat.IngredientEtat;

public class Epice extends Ingredient{
    public Epice(String nom, EtatIngredient etat, double quantite) {
        super(nom,TypeIngredient.EPICE, etat, quantite);
    }
}

/**
 * Creates a new Epice object with the given name, state, and quantity.
 * The type of ingredient is set to TypeIngredient.EPICE.
 * @param nom The name of the spice.
 * @param etat The state of the spice.
 * @param quantite The quantity of the spice.
 */