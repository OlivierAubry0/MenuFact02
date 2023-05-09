package ingredients;

import ingredients.etat.IngredientEtat;

public class Epice extends Ingredient{
    public Epice(String nom, IngredientEtat etat, double quantite) {
        super(nom,TypeIngredient.EPICE, etat, quantite);
    }
}
