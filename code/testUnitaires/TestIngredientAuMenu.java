package testUnitaires;

import ingredients.*;
import ingredients.etat.IngredientLiquide;
import ingredients.etat.IngredientSolide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientAuMenuTest {

    private Ingredient ingredient;
    private Ingredient ingredient2;

    @BeforeEach
    public void setUp() throws Exception {
        ingredient = new Laitier();
        ingredient2 = new Legume();
    }

    @Test
    void setNom() {
        ingredient.setNom("Lait");
        assertEquals("Lait", ingredient.getNom());
    }

    @Test
    void setDescription() {
        ingredient.setDescription("Berlingot de lait");
        assertEquals("Berlingot de lait", ingredient.getDescription());
    }

    @Test
    void setEtat() {
        ingredient.setEtat(new IngredientLiquide());
        assertEquals("ml", ingredient.getEtat().getUnit());
    }

    @Test

    void setEtat2(){
        ingredient2.setEtat(new IngredientSolide());
        assertEquals("g", ingredient2.getEtat().getUnit());
    }
    @Test
    void setType() {
        ingredient.setType(TypeIngredient.LAITIER);
        assertEquals(TypeIngredient.LAITIER, ingredient.getType());
    }
}
