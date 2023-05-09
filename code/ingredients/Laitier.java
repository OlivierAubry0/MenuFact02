package ingredients;

import ingredients.etat.EtatIngredient;

public class Laitier extends Ingredient{
    public Laitier(String nom, EtatIngredient etat, double quantite) {
        super(nom,TypeIngredient.LAITIER, etat, quantite);
    }
}
