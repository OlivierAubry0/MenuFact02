package ingredients;

import ingredients.etat.IngredientEtat;

public class Viande extends Ingredient{
    public Viande(String nom, IngredientEtat etat, double quantite) {
        super(nom, TypeIngredient.VIANDE, etat, quantite);
    }
}
