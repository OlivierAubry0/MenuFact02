package testUnitaires;

import menufact.factory.plats.PlatChoisi;
import menufact.factory.plats.PlatFactory;
import menufact.observer.Facture;
import menufact.observer.exceptions.FactureException;
import menufact.Chef;
import menufact.Client;
import ingredients.*;
import menufact.factory.plats.*;
import inventaire.Inventaire;
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
    private IngredientsAuMenu oignon;

    @BeforeEach
    void setUp() {
        client = new Client(1,"John Doe", "1234567890");
        chef = chef.getInstance("Chef Gordon");
        platFactory = new PlatFactory();
        facture = new Facture("Facture Test");
        facture.associerClient(client);
        facture.associerChef(chef);
        inventaire = Inventaire.getInventaire();
        patate = new Legume();

    }

    @Test
    void testCommandeAuRestaurant() {
        // Ajouter des ingrédients à l'inventaire
        inventaire.addIngredient(patate, 10);
        inventaire.addIngredient(oignon, 10);

        try {
            // Créer un plat
            PlatAuMenu plat1 = platFactory.createPlat("Poutine", 1,"Menoum menoum",9.99,);
            PlatChoisi platChoisi1 = new PlatChoisi(plat1, 1);

            // Ajouter le plat à la facture
            facture.ajoutePlat(platChoisi1);

            // Payer la facture
            facture.payer();

            // Fermer la facture
            facture.fermer();

            // Tenter d'ajouter un autre plat à la facture fermée
            PlatAuMenu plat2 = platFactory.createPlat("Salade", 6.99);
            PlatChoisi platChoisi2 = new PlatChoisi(plat2, 1);

            assertThrows(FactureException.class, () -> {
                facture.ajoutePlat(platChoisi2);
            });

        } catch (FactureException | PlatException e) {
            fail("Exception non attendue: " + e.getMessage());
        }
    }
}
