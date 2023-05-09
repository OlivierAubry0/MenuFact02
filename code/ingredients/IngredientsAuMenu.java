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


        Ingredient nouvelIngredient;
        switch (type) {
            case FRUIT:
                nouvelIngredient = new Fruit(nom, etat, quantite);
                break;
            case LEGUME:
                nouvelIngredient = new Legume(nom, etat, quantite);
                break;
            case VIANDE:
                nouvelIngredient = new Viande(nom, etat, quantite);
                break;
            case LAITIER:
                nouvelIngredient = new Laitier(nom, etat, quantite);
                break;
            case EPICE:
                nouvelIngredient = new Epice(nom, etat, quantite);
                break;
            default:
                throw new IllegalArgumentException("Type d'ingrédient non reconnu : " + type);
        }

        ingredients.put(nom, nouvelIngredient);
        return nouvelIngredient;
    }
}

/**
 * Creates a new IngredientAuMenu object with the given name, type of ingredient, state of the ingredient, and quantity of the ingredient.
 * @param nom The name of the ingredient.
 * @param typeIngredient The type of ingredient.
 * @param etatIngredient The state of the ingredient.
 * @param quantite The quantity of the ingredient.
 */


