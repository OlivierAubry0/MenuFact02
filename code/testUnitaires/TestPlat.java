package testUnitaires;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.Laitier;
import ingredients.Legume;
import ingredients.etat.EtatIngredient;
import menufact.Builder.Recette;
import menufact.Builder.RecetteBuilder;
import menufact.factory.plats.*;
import menufact.factory.exceptions.PlatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPlat {

    private PlatFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PlatFactory();
    }

    @Test
    void testCreatePlatAuMenu() throws PlatException {
        Ingredient Tomate = new Legume("Tomate", EtatIngredient.SOLIDE, 150);
        Ingredient Fromage = new Laitier("Fromage", EtatIngredient.SOLIDE, 25);
        Ingredient Sauce = new Epice("Sauce", EtatIngredient.LIQUIDE, 5);
        RecetteBuilder pizzaBuilder = new RecetteBuilder();
        pizzaBuilder.addIngredient(Tomate, 3)
                .addIngredient(Fromage, 20)
                .addIngredient(Sauce, 1);
        Recette pizza = pizzaBuilder.build();
        PlatAuMenu plat = factory.createPlat(5, "Pizza", 5.99);
        assertTrue(plat instanceof PlatAuMenu);
        assertEquals(5, ((PlatAuMenu) plat).getCode());
        assertEquals("Pizza", ((PlatAuMenu) plat).getDescription());
        assertEquals(5.99, ((PlatAuMenu) plat).getPrix());
    }

    @Test
    void testCreatePlatEnfant() throws PlatException {
        Ingredient Tomate = new Legume("Tomate", EtatIngredient.SOLIDE, 150);
        Ingredient Fromage = new Laitier("Fromage", EtatIngredient.SOLIDE, 25);
        Ingredient Sauce = new Epice("Sauce", EtatIngredient.LIQUIDE, 5);
        RecetteBuilder pizzaBuilder = new RecetteBuilder();
        pizzaBuilder.addIngredient(Tomate, 3)
                .addIngredient(Fromage, 20)
                .addIngredient(Sauce, 1);
        Recette pizza = pizzaBuilder.build();
        PlatEnfant plat = factory.createPlatEnfant(2, "Burger", 8.0, pizza, 0.5);
        assertTrue(plat instanceof PlatEnfant);
        assertEquals(2, ((PlatEnfant) plat).getCode());
        assertEquals("Burger", ((PlatEnfant) plat).getDescription());
        assertEquals(8.0, ((PlatEnfant) plat).getPrix());
        assertEquals(0.5, ((PlatEnfant) plat).getProportion());
    }

    @Test
    void testCreatePlatSante() throws PlatException {
        Ingredient Tomate = new Legume("Tomate", EtatIngredient.SOLIDE, 150);
        Ingredient Fromage = new Laitier("Fromage", EtatIngredient.SOLIDE, 25);
        Ingredient Sauce = new Epice("Sauce", EtatIngredient.LIQUIDE, 5);
        RecetteBuilder pizzaBuilder = new RecetteBuilder();
        pizzaBuilder.addIngredient(Tomate, 3)
                .addIngredient(Fromage, 20)
                .addIngredient(Sauce, 1);
        Recette pizza = pizzaBuilder.build();
        PlatSante plat = factory.createPlatSante(3, "Salad", 10.0, pizza, 350, 10, 5);
        assertTrue(plat instanceof PlatSante);
        assertEquals(3, ((PlatSante) plat).getCode());
        assertEquals("Salad", ((PlatSante) plat).getDescription());
        assertEquals(10.0, ((PlatSante) plat).getPrix());
        assertEquals(350, ((PlatSante) plat).getKcal());
        assertEquals(5, ((PlatSante) plat).getChol());
        assertEquals(10, ((PlatSante) plat).getGras());
    }

    @Test
    void testCreatePlatChoisi() throws PlatException {
        Ingredient Tomate = new Legume("Tomate", EtatIngredient.SOLIDE, 150);
        Ingredient Fromage = new Laitier("Fromage", EtatIngredient.SOLIDE, 25);
        Ingredient Sauce = new Epice("Sauce", EtatIngredient.LIQUIDE, 5);
        RecetteBuilder pizzaBuilder = new RecetteBuilder();
        pizzaBuilder.addIngredient(Tomate, 3)
                .addIngredient(Fromage, 20)
                .addIngredient(Sauce, 1);
        Recette pizza = pizzaBuilder.build();
        PlatAuMenu platAuMenu = factory.createPlat(4, "Pizza", 11.0);
        PlatChoisi plat = new PlatChoisi(platAuMenu, 3);
        assertTrue(plat instanceof PlatChoisi);
        PlatAuMenu expectedPlatAuMenu = new PlatAuMenu(4, "Pizza", 11.0);
        assertEquals(4, (expectedPlatAuMenu).getCode());
        assertEquals("Pizza", (expectedPlatAuMenu).getDescription());
        assertEquals(11.0, (expectedPlatAuMenu).getPrix());
    }
}
