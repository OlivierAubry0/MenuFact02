
package testUnitaires;


import menufact.singleton.Menu;
import menufact.exceptions.MenuException;
import menufact.factory.plats.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

//Client

class TestMenu {
    private Menu menu;
    private ArrayList<PlatAuMenu> platAuMenu;
    private FactoryPlatAuMenu factoryPlatAuMenu;
    private int counter = 0;

    @BeforeEach
    public void setup() {
        menu = Menu.getMenu("resto");
        factoryPlatAuMenu = new FactoryPlatAuMenu();
        platAuMenu = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            PlatAuMenu plat = factoryPlatAuMenu.createPlat();
            platAuMenu.add(plat);
            menu.ajoute(plat);
            platAuMenu.get(i).setCode(i);
            platAuMenu.get(i).setDescription("plat" + i);
        }
        menu.setDescription("La roulotte a graton");
    }

    @Test
    public void ajoute() {
        PlatAuMenu plat = factoryPlatAuMenu.createPlat();
        plat.setCode(10);
        plat.setDescription("Plat Ajoute");
        menu.ajoute(plat);
        Assertions.assertEquals(plat, menu.getPlatAuMenu(plat.getCode()));
    }

    @Test
    public void position() throws MenuException {
        menu.position(3);
        Assertions.assertEquals(3, menu.getPosition());
    }

    @Test
    public void platCourant() {
        Assertions.assertEquals(platAuMenu.get(2).getCode(), menu.platCourant().getCode());
        Assertions.assertEquals(platAuMenu.get(2).getDescription(), menu.platCourant().getDescription());
    }

    @Test
    public void getPlatAuMenu() {
        Assertions.assertEquals(platAuMenu.get(1).getCode(), menu.getPlatAuMenu(platAuMenu.get(1).getCode()).getCode());
        Assertions.assertEquals(platAuMenu.get(1).getDescription(), menu.getPlatAuMenu(platAuMenu.get(1).getCode()).getDescription());
    }

    @Test
    public void positionSuivante() throws MenuException {
        menu.positionSuivante();
        menu.positionSuivante();
        Assertions.assertEquals(platAuMenu.get(2).getCode(), menu.platCourant().getCode());
        Assertions.assertEquals(platAuMenu.get(2).getDescription(), menu.platCourant().getDescription());
    }

    @Test
    public void positionPrecedente() throws MenuException {
        menu.position(2);
        menu.positionPrecedente();
        Assertions.assertEquals(platAuMenu.get(1).getCode(), menu.platCourant().getCode());
        Assertions.assertEquals(platAuMenu.get(1).getDescription(), menu.platCourant().getDescription());
    }

    @Test
    public void getDescription() {
        Assertions.assertEquals("La roulotte a graton", menu.getDescription());
    }

    @Test
    public void setDescription() {
        menu.setDescription("Mon ami pierrot");
        Assertions.assertEquals("Mon ami pierrot", menu.getDescription());
    }

    @Test
    public void getMenu() {
        Assertions.assertEquals(menu, Menu.getMenu("resto"));
    }

}