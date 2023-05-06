package testUnitaires;

import menufact.Chef;
import menufact.Client;
import menufact.factory.plats.PlatAuMenu;
import menufact.factory.plats.PlatChoisi;
import menufact.factory.plats.exceptions.PlatException;
import menufact.observer.facture.Facture;
import menufact.observer.facture.exceptions.FactureException;
import menufact.state.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestChef {
    PlatChoisi plat;
    Facture facture;
    @BeforeEach
    public void setup(){
        facture = new Facture("Nouvelle Facture");
        facture.associerClient(new Client(1,"batman", "1111"));
        facture.associerChef(Chef.getInstance("joker"));
        plat = new PlatChoisi(new PlatAuMenu(),2);


    }
    @Test
    void fairePlat() throws FactureException, PlatException{
        Chef joker;
        joker = Chef.getInstance("joker");
        joker.cuisiner(plat);
        Assertions.assertTrue(plat.getState() instanceof Servie);
    }
    @Test

    void terminerCommande() throws FactureException, PlatException {
        Chef joker;
        joker = Chef.getInstance("joker");
        joker.cuisiner(plat);
        facture.ajoutePlat(plat);
        facture.genererFacture();
        Assertions.assertTrue(plat.getState() instanceof Terminee);
    }

    @Test

    void commandeEnCours() throws FactureException, PlatException{
        Chef joker;
        joker = Chef.getInstance("joker");
        joker.cuisiner(plat);
        facture.ajoutePlat(plat);
        Assertions.assertTrue(plat.getState() instanceof EnCours);
    }
}


