
package testUnitaires;


import ingredients.Laitier;
import ingredients.etat.EtatIngredient;
import menufact.Builder.RecetteBuilder;
import menufact.singleton.Menu;
import menufact.exceptions.MenuException;
import menufact.factory.plats.*;
import menufact.Builder.Recette;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

//Client

class TestMenu {
    private Menu menu;
    private ArrayList<PlatAuMenu> platAuMenu;
    private PlatFactory factoryPlatAuMenu;

    @BeforeEach
    public void setup() {
        menu = Menu.getMenu("resto");
        factoryPlatAuMenu = new PlatFactory();
        platAuMenu = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Recette recette = new Recette(); // Ajoutez les ingrédients nécessaires à la recette ici.
            PlatAuMenu plat = factoryPlatAuMenu.createPlat(3, "oui oui", 15.45);
            platAuMenu.add(plat);
            menu.ajoute(plat);
        }
        menu.setDescription("La roulotte a graton");
    }


    @Test
    public void ajoute(){
        Recette recette = new Recette(); // Ajoutez les ingrédients nécessaires à la recette ici.
        Laitier fromage = new Laitier("cheddar", EtatIngredient.SOLIDE,2);

        RecetteBuilder recetteBuilder = new RecetteBuilder();
        recetteBuilder.addIngredient(fromage,2);
        recette = recetteBuilder.build();

        PlatAuMenu plat = factoryPlatAuMenu.createPlat(3, "oui oui", 15.45);
        menu.ajoute(plat);
        Menu.associerRecetteAuPlat(plat,recette);
        Assertions.assertEquals(plat.getCode(), 3);
        Assertions.assertEquals(plat.getDescription(), "oui oui");
        Assertions.assertEquals(plat.getPrix(), 15.45);
        Assertions.assertEquals(plat.getRecette(3), recette);

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
    public void getPlatAuMenu() throws MenuException {
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