package testUnitaires;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.Laitier;
import ingredients.Legume;
import ingredients.etat.EtatIngredient;
import menufact.Builder.Recette;
import menufact.Builder.RecetteBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RecetteTest {
    private Recette recette;
    private Map<Ingredient, Integer> ingredients;

    @BeforeEach
    void setUp() {
        ingredients = new HashMap<>();

    }

    @Test
    void testGetIngredients() {
        Ingredient Tomate = new Legume("Tomate", EtatIngredient.SOLIDE.getEtat(), 150);
        Ingredient Fromage = new Laitier("Fromage", EtatIngredient.SOLIDE.getEtat(), 25);
        Ingredient Sauce = new Epice("Sauce", EtatIngredient.LIQUIDE.getEtat(), 5);
        RecetteBuilder pizzaBuilder = new RecetteBuilder();
        pizzaBuilder.addIngredient(Tomate, 3)
                    .addIngredient(Fromage, 20)
                    .addIngredient(Sauce, 1);
        Recette pizza = pizzaBuilder.build();
        Map<Ingredient, Double> result = pizza.getIngredients();
        assertNotNull(result);
        assertEquals(ingredients, result);
    }
}

