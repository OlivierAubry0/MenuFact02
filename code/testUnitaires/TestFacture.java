package testUnitaires;

import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatFactory;
import menufact.observer.Facture;
import menufact.observer.exceptions.FactureException;
import menufact.Chef;
import menufact.Client;
import ingredients.*;
import menufact.Builder.Recette;
import inventaire.Inventaire;
import java.util.Map
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {
    Facture facture;
    Client client;
    Chef chef;
    PlatFactory platFactory;
    Inventaire inventaire;
    private IngredientsAuMenu patate;
    private IngredientsAuMenu fromage;
    private IngredientsAuMenu sauce;
    private Map<Ingredient, Integer> IngredientPoutine;

    @BeforeEach
    void setUp() throws FactureException {
        client = new Client(1,"John Doe", "1234567890");
        chef = chef.getInstance("Chef Gordon");
        platFactory = new PlatFactory();
        facture = new Facture("Facture Test");
        facture.associerClient(client);
        facture.associerChef(chef);
        inventaire = Inventaire.getInventaire();
        patate = new Legume();
        fromage = new Laitier();
        sauce = new Viande();
        IngredientPoutine.put(patate, 5);
        IngredientPoutine.put(fromage, 10);
        IngredientPoutine.put(sauce, 12);

    }

    @Test
    void testCommandeAuRestaurant() throws FactureException, PlatException {
        // Ajouter des ingrédients à l'inventaire
        inventaire.addIngredient(patate, 100);
        inventaire.addIngredient(fromage, 50);
        inventaire.addIngredient(sauce, 500);

        try {

            Recette poutine = new Recette(IngredientPoutine);
            PlatFactory plat1;
            plat1 = new PlatFactory();
            plat1.createPlat();

            // Vérifier si l'inventaire a suffisamment d'ingrédients pour préparer le plat
            if (inventaire.hasSufficientIngredients(plat1.getRecette())) {
                // Ajouter le plat à la facture
                facture.ajoutePlat(platChoisi1);

                // Payer la facture
                // ...
            } else {
                fail("Il n'y a pas assez d'ingrédients pour préparer le plat.");
            }

            // ...

        } catch (FactureException | PlatException e) {
            fail("Exception non attendue: " + e.getMessage());
        }
    }

}
