package testUnitaires;

import menufact.Client;
import menufact.Chef;
import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatChoisi;
import menufact.factory.plats.PlatAuMenu;
import menufact.observer.Facture;
import menufact.state.EnCours;
import menufact.state.Terminee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {
    private Chef chef;
    private Facture facture;
    private Client client;
    private PlatChoisi plat;

    @BeforeEach
    void setUp() throws PlatException{
        chef = Chef.getInstance("Chef John");
        client = new Client(1,"John Doe","123456789");
        facture = new Facture("Test Facture");
        plat = new PlatChoisi(new PlatAuMenu(0, "Test Plat", 15.0), 2);
        facture.associerChef(chef);
        facture.associerClient(client);
    }

    @Test
    void chefShouldReceiveNotification() throws PlatException{
        // Add the Chef as an observer to the Facture
        facture.addObserver(chef);

        // Add a PlatChoisi to the Facture
        try {
            facture.ajoutePlat(plat);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Check if the Chef's state has been updated
        assertEquals(EnCours.class, plat.getState().getClass());

        // Generate the Facture
        facture.genererFacture();

        // Check if the Chef's state has been updated after generating the Facture
        assertEquals(Terminee.class, plat.getState().getClass());
    }
}

