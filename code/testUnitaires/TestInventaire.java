package testUnitaires;

import ingredients.*;
import ingredients.etat.EtatIngredient;
import inventaire.Inventaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestInventaire {

    private Inventaire inventaire;
    private Map<Ingredient,Double> ingredient = new HashMap<>();
    private Ingredient epice;
    private void assertArrayEquals(Inventaire inventaire, Inventaire inventaire1) {
    }
    @BeforeEach
    public void setUp() throws Exception {
        inventaire = Inventaire.getInventaire();
        epice = new Epice("Poivre", EtatIngredient.SOLIDE, 1);
        ingredient.put(epice,2.0);
    }

    @Test
    void getInventaire() {
        assertArrayEquals(inventaire, Inventaire.getInventaire());
    }

    @Test
    void addIngredient() {
        inventaire.addIngredient2(epice,2);
        assertEquals(ingredient, inventaire.getIngredients());
    }
}