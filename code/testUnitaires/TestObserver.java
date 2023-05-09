package testUnitaires;

import menufact.Client;
import menufact.Chef;
<<<<<<< Updated upstream
import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatChoisi;
import menufact.factory.plats.PlatAuMenu;
import menufact.observer.Facture;
=======
import menufact.factory.plats.PlatChoisi;
import menufact.factory.plats.PlatAuMenu;
import menufact.observer.Facture;
import menufact.observer.exceptions.FactureException;
>>>>>>> Stashed changes
import menufact.state.EnCours;
import menufact.state.Terminee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

<<<<<<< Updated upstream
=======
import menufact.factory.exceptions.PlatException;

>>>>>>> Stashed changes
import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {
    private Chef chef;
    private Facture facture;
    private Client client;
<<<<<<< Updated upstream
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
=======
    private PlatAuMenu platAuMenu;
    private PlatChoisi platChoisi;

    @BeforeEach
    void setUp() {
        try {
            chef = Chef.getInstance("Chef John");
            client = new Client(1, "John Doe", "1234-5678-9012-3456");
            facture = new Facture("Test Facture");
            platAuMenu = new PlatAuMenu(0, "Test Plat", 15.0);
            platChoisi = new PlatChoisi(platAuMenu, 1);
            facture.associerChef(chef);
            facture.associerClient(client);
        } catch (PlatException e) {
            e.printStackTrace();
        }
    }

    @Test
    void chefShouldReceiveNotification() {
>>>>>>> Stashed changes
        // Add the Chef as an observer to the Facture
        facture.addObserver(chef);

        // Add a PlatChoisi to the Facture
        try {
<<<<<<< Updated upstream
            facture.ajoutePlat(plat);
        } catch (Exception e) {
=======
            facture.ajoutePlat(platChoisi);
        } catch (FactureException | PlatException e) {
>>>>>>> Stashed changes
            e.printStackTrace();
        }

        // Check if the Chef's state has been updated
<<<<<<< Updated upstream
        assertEquals(EnCours.class, plat.getState().getClass());
=======
        assertEquals(EnCours.class, platChoisi.getState().getClass());
>>>>>>> Stashed changes

        // Generate the Facture
        facture.genererFacture();

        // Check if the Chef's state has been updated after generating the Facture
<<<<<<< Updated upstream
        assertEquals(Terminee.class, plat.getState().getClass());
    }
}

=======
        assertEquals(Terminee.class, platChoisi.getState().getClass());
    }
}
>>>>>>> Stashed changes
