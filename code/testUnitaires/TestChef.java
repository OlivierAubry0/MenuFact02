package testUnitaires;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import menufact.Chef;
import menufact.factory.plats.PlatAuMenu;
import menufact.factory.plats.PlatChoisi;
import menufact.factory.exceptions.PlatException;
import menufact.state.EnCours;
import menufact.state.Servie;

public class TestChef {

    Chef chef;
    PlatAuMenu platAuMenu;
    PlatChoisi platChoisi;

    @BeforeEach
    public void setUp() {
        chef = Chef.getInstance("Chef Test");
        platAuMenu = new PlatAuMenu(1, "Poulet", 12.99);
        platChoisi = new PlatChoisi(platAuMenu, 2);
    }

    @Test
    public void testCuisiner() throws PlatException {
        chef.cuisiner(platChoisi);
        assertTrue(platChoisi.getState() instanceof EnCours);
    }

    @Test
    public void testServir() throws PlatException {
        chef.cuisiner(platChoisi);
        chef.servir(platChoisi);
        assertTrue(platChoisi.getState() instanceof  Servie);
    }

    @Test
    public void testGetInstance() {
        assertTrue(chef == Chef.getInstance("Chef Test"));
    }
}
