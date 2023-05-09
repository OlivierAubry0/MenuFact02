package ingredients;

import ingredients.etat.IngredientEtat;

public class Laitier extends Ingredient{
    public Laitier(String nom, IngredientEtat etat, double quantite) {
        super(nom,TypeIngredient.LAITIER, etat, quantite);
    }
}
