package ingredients;

import ingredients.etat.EtatIngredient;
import ingredients.etat.IngredientEtat;

public class Epice extends Ingredient{
    public Epice(String nom, EtatIngredient etat, double quantite) {
        super(nom,TypeIngredient.EPICE, etat, quantite);
    }
}
