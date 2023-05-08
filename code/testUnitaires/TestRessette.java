package testUnitaires;

import ingredients.Ingredient;
import menufact.Builder.Recette;
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
        recette = new Recette(ingredients);
    }

    @Test
    void testGetIngredients() {
        Map<Ingredient, Integer> result = recette.getIngredients();
        assertNotNull(result);
        assertEquals(ingredients, result);
    }

    @Test
    void testSetIngredients() {
        Map<Ingredient, Integer> newIngredients = new HashMap<>();
        recette.setIngredients(newIngredients);
        assertEquals(newIngredients, recette.getIngredients());
    }
}

