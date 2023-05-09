package menufact.singleton;

import menufact.exceptions.MenuException;
import menufact.factory.plats.*;
import menufact.factory.exceptions.PlatException;
import menufact.Builder.Recette;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plats = new ArrayList<PlatAuMenu>();
    private static Map<Integer, Recette> recettesParPlat = new HashMap<>();

    private Menu(String description) {
        this.description = description;
    }

    public void ajoute(PlatAuMenu p) {
        plats.add(p);
    }

    public static void associerRecetteAuPlat(PlatAuMenu plat, Recette recette) {
        recettesParPlat.put(plat.getCode(), recette);
    }

    public Recette getRecettePourPlat(PlatAuMenu plat) throws MenuException {
        Recette recette = recettesParPlat.get(plat.getCode());
        if (recette == null) {
            throw new MenuException("Aucune recette associée à ce plat: " + plat.getCode());
        }
        return recette;
    }


    public void position(int i) {
        courant = i;
    }

    public static Menu menu;

    public static Menu getMenu(String description) {
        if (menu == null) {
            menu = new Menu(description);
        }
        return menu;
    }

    public PlatAuMenu platCourant() {
        return plats.get(courant);
    }

    public void positionSuivante() throws MenuException {
        if (courant + 1 <= plats.size())
            courant++;
    }

    public void positionPrecedente() throws MenuException {
        if (courant - 1 > 0)
            courant--;
    }

    public int getPosition() {
        return courant;
    }

    public String getDescription() {
        return description;
    }

    public PlatAuMenu getPlatAuMenu(int code) throws MenuException {
        for (PlatAuMenu plat : plats) {
            if (plat.getCode() == code) {
                return plat;
            }
        }
        throw new MenuException("Le plat avec le code " + code + " n'est pas au menu.");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plats +
                '}';
    }
}
