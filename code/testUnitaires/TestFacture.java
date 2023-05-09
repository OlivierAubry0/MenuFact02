package testUnitaires;

import ingredients.etat.EtatIngredient;
import menufact.Builder.RecetteBuilder;
import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatAuMenu;
import menufact.factory.plats.PlatFactory;
import menufact.observer.Facture;
import menufact.observer.exceptions.FactureException;
import menufact.Chef;
import menufact.Client;
import ingredients.*;
import menufact.Builder.Recette;
import inventaire.Inventaire;
import menufact.factory.plats.*;

import java.util.Map;

import menufact.singleton.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFacture {
    Facture facture;
    Client client;
    Chef chef;
    private Menu menu;

    private Inventaire inventaire;
    PlatFactory platFactory;
    private Recette poutine;
    private Map<Ingredient, Integer> IngredientPoutine;

    @BeforeEach
    void setUp() throws FactureException {
        client = new Client(1,"John Doe", "1234567890");
        chef = chef.getInstance("Chef Gordon");
        platFactory = new PlatFactory();
        facture = new Facture("Facture Test");
        facture.associerClient(client);
        facture.associerChef(chef);

        Ingredient Patate = new Legume("Patate", EtatIngredient.SOLIDE, 1);
        Ingredient Fromage = new Laitier("Fromage", EtatIngredient.SOLIDE, 1);
        Ingredient Sauce = new Epice("Sauce", EtatIngredient.LIQUIDE, 1);
        RecetteBuilder poutineBuilder = new RecetteBuilder();
        poutineBuilder.addIngredient(Patate,3)
                .addIngredient(Fromage, 20)
                .addIngredient(Sauce, 1);
        poutine =  poutineBuilder.build();
        facture = new Facture("Nouvelle Facture");
        facture.associerClient(new Client(1,"batman", "1111"));
        facture.associerChef(Chef.getInstance("joker"));

    }


    @Test
    void testCommandeAuRestaurant() throws FactureException, PlatException {
        try {

            PlatChoisi plat1;
            plat1 = new PlatChoisi(new PlatAuMenu(1,"Poutine",9.99),2);
            menu = Menu.getMenu("resto");
            menu.ajoute(plat1);
            Menu.associerRecetteAuPlat(plat1,poutine);

            inventaire.addIngredient("Patate", TypeIngredient.LEGUME, EtatIngredient.SOLIDE, 1);
            inventaire.addIngredient("Fromage", TypeIngredient.LAITIER, EtatIngredient.SOLIDE, 1);
            inventaire.addIngredient("Sauce", TypeIngredient.VIANDE, EtatIngredient.LIQUIDE, 1);
            inventaire = Inventaire.getInventaire();

            if (inventaire.hasSufficientIngredients(plat1.getRecette(1))) {
                facture.ajoutePlat(plat1);
            } else {
                fail("Il n'y a pas assez d'ingrédients pour préparer le plat.");
            }

        } catch (FactureException | PlatException e) {
            fail("Exception non attendue: " + e.getMessage());
        }
    }

}
