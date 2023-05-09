package testUnitaires;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.Laitier;
import ingredients.Legume;
import ingredients.etat.EtatIngredient;
import ingredients.etat.IngredientEtat;
import menufact.Builder.Recette;
import menufact.Builder.RecetteBuilder;
import menufact.Chef;
import menufact.factory.plats.PlatAuMenu;
import menufact.factory.plats.PlatChoisi;
import menufact.observer.Facture;
import menufact.observer.exceptions.*;
import menufact.factory.exceptions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {
    Facture facture;
    Chef chef;
    PlatChoisi platChoisi;

    @BeforeEach
    void setUp() {
        chef = Chef.getInstance("Chef Gordon");
        facture = new Facture("Facture Test");
        facture.registerObserver(chef);
        Ingredient Patate = new Legume("Patate", EtatIngredient.SOLIDE, 150);
        Ingredient Fromage = new Laitier("Fromage", EtatIngredient.SOLIDE, 25);
        Ingredient Sauce = new Epice("Sauce", EtatIngredient.LIQUIDE, 5);
        RecetteBuilder poutineBuilder = new RecetteBuilder();
        poutineBuilder.addIngredient(Patate,3)
                .addIngredient(Fromage, 20)
                .addIngredient(Sauce, 1);
        Recette poutine =  poutineBuilder.build();
        platChoisi = new PlatChoisi(new PlatAuMenu(1,"Poutine",9.99),2);
    }


    @Test
    void testNotificationChef() {
        try {
            facture.ajoutePlat(platChoisi);
            assertTrue(facture.getPlats().contains(platChoisi));
        } catch (FactureException | PlatException e) {
            fail("Exception non attendue lors de l'ajout du plat à la facture : " + e.getMessage());
        }
    }
}
