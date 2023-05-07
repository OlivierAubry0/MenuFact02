import menufact.factory.plats.*;
import menufact.factory.exceptions.PlatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatsTest {

    private PlatFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PlatFactory();
    }

    @Test
    void testCreatePlatAuMenu() throws PlatException {
        Plat plat = factory.createPlat("AuMenu", 1, "Pizza", 12.0, 0, 0, 0, 0);
        assertTrue(plat instanceof PlatAuMenu);
        assertEquals(1, ((PlatAuMenu) plat).getCode());
        assertEquals("Pizza", ((PlatAuMenu) plat).getDescription());
        assertEquals(12.0, ((PlatAuMenu) plat).getPrix());
    }

    @Test
    void testCreatePlatEnfant() throws PlatException {
        Plat plat = factory.createPlat("Enfant", 2, "Burger", 8.0, 0.5, 0, 0, 0);
        assertTrue(plat instanceof PlatEnfant);
        assertEquals(2, ((PlatEnfant) plat).getCode());
        assertEquals("Burger", ((PlatEnfant) plat).getDescription());
        assertEquals(8.0, ((PlatEnfant) plat).getPrix());
        assertEquals(0.5, ((PlatEnfant) plat).getProportion());
    }

    @Test
    void testCreatePlatSante() throws PlatException {
        Plat plat = factory.createPlat("Sante", 3, "Salad", 10.0, 0, 350, 10, 5);
        assertTrue(plat instanceof PlatSante);
        assertEquals(3, ((PlatSante) plat).getCode());
        assertEquals("Salad", ((PlatSante) plat).getDescription());
        assertEquals(10.0, ((PlatSante) plat).getPrix());
        assertEquals(350, ((PlatSante) plat).getKcal());
        assertEquals(10, ((PlatSante) plat).getChol());
        assertEquals(5, ((PlatSante) plat).getGras());
    }

    @Test
    void testCreatePlatChoisi() throws PlatException {
        Plat plat = factory.createPlat("Choisi", 4, "Pasta", 11.0, 0, 0, 0, 0);
        assertTrue(plat instanceof PlatChoisi);
        PlatAuMenu expectedPlatAuMenu = new PlatAuMenu(4, "Pasta", 11.0);
        assertEquals(expectedPlatAuMenu.toString(), ((PlatChoisi) plat).getPlat().toString());
        assertEquals(1, ((PlatChoisi) plat).getQuantite());
    }

    @Test
    void testInvalidPlatType() throws PlatException {
        assertNull(factory.createPlat("InvalidType", 5, "Invalid", 0, 0, 0, 0, 0));
    }
}
