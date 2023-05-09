package ingredients;

import ingredients.etat.EtatIngredient;

public class Fruit extends Ingredient {
    public Fruit(String nom, EtatIngredient etat, double quantite) {
        super(nom,TypeIngredient.FRUIT, etat, quantite);
    }
}

