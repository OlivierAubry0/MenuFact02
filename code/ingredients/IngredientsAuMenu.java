package ingredients;

import ingredients.etat.*;
import ingredients.Ingredient;
import ingredients.etat.IngredientEtat;
import java.util.HashMap;
import java.util.Map;

public class IngredientsAuMenu {
    private Map<String, Ingredient> ingredients;

    public IngredientsAuMenu() {
        ingredients = new HashMap<>();
    }

    public Ingredient getIngredient(String nom, double quantite, TypeIngredient type, EtatIngredient etat) {
        if (ingredients.containsKey(nom)) {
            return ingredients.get(nom);
        }

        IngredientEtat Etat = etat.getEtat();

        Ingredient nouvelIngredient;
        switch (type) {
            case FRUIT:
                nouvelIngredient = new Fruit(nom, Etat, quantite);
                break;
            case LEGUME:
                nouvelIngredient = new Legume(nom, Etat, quantite);
                break;
            case VIANDE:
                nouvelIngredient = new Viande(nom, Etat, quantite);
                break;
            case LAITIER:
                nouvelIngredient = new Laitier(nom, Etat, quantite);
                break;
            case EPICE:
                nouvelIngredient = new Epice(nom, Etat, quantite);
                break;
            default:
                throw new IllegalArgumentException("Type d'ingrédient non reconnu : " + type);
        }

        ingredients.put(nom, nouvelIngredient);
        return nouvelIngredient;
    }
}


