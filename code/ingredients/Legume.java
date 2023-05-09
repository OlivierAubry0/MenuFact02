package ingredients;

import ingredients.etat.EtatIngredient;

public class Legume extends Ingredient{
    public Legume(String nom, EtatIngredient etat, double quantite) {
        super(nom, TypeIngredient.LEGUME, etat, quantite);
    }
}
