package ingredients;

import ingredients.etat.EtatIngredient;

public class Viande extends Ingredient{
    public Viande(String nom, EtatIngredient etat, double quantite) {
        super(nom, TypeIngredient.VIANDE, etat, quantite);
    }
}
