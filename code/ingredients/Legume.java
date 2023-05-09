package ingredients;

import ingredients.etat.IngredientEtat;

public class Legume extends Ingredient{
    public Legume(String nom, IngredientEtat etat, double quantite) {
        super(nom, TypeIngredient.LEGUME, etat, quantite);
    }
}
