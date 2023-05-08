package testUnitaires;

import ingredients.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryIngredientsTest {

    private FactoryIngredient lait;
    private FactoryIngredient epice;
    private FactoryIngredient fruit;
    private FactoryIngredient legume;
    private FactoryIngredient viande;

    @BeforeEach
    public void setUp() throws Exception {
        lait = new FactoryLaitier();
        epice = new FactoryEpice();
        fruit = new FactoryFruit();
        legume = new FactoryLegume();
        viande = new FactoryViande();
    }

    @Test
    void createIngredients() {
        assertTrue(lait.createIngredients() instanceof Laitier);
        assertTrue(epice.createIngredients() instanceof Epice);
        assertTrue(fruit.createIngredients() instanceof Fruit);
        assertTrue(legume.createIngredients() instanceof Legume);
        assertTrue(viande.createIngredients() instanceof Viande);
    }
}