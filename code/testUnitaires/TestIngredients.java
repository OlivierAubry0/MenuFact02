package testUnitaires;

import ingredients.*;
import ingredients.etat.EtatIngredient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestIngredients {

    @Test
    void testCreation() {
        Ingredient ingredient = new Fruit("Pomme", EtatIngredient.SOLIDE, 2);
        assertEquals("Pomme", ingredient.getNom());
        assertEquals(TypeIngredient.FRUIT, ingredient.getTypeIngredient());
        assertEquals("SOLIDE", ingredient.getEtatIngredient().toString());
        assertEquals(2, ingredient.getQuantite());
    }
}
