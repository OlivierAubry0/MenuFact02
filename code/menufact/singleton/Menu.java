package menufact.singleton;

import menufact.exceptions.MenuException;
import menufact.factory.plats.*;
import menufact.factory.exceptions.PlatException;
import menufact.Builder.Recette;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
/**

 The Menu class represents a menu in a restaurant. It holds a collection of dishes,
 which are represented by PlatAuMenu objects, and allows the user to navigate through
 the menu and retrieve recipes associated with the dishes.
 */
public class Menu {
    /** A description of the menu */
    private String description;

    /** The current position in the menu */
    private int courant;

    /** The list of dishes available on the menu */
    private ArrayList<PlatAuMenu> plats = new ArrayList<PlatAuMenu>();

    /** A map of recipes associated with each dish */
    private static Map<Integer, Recette> recettesParPlat = new HashMap<>();

    /** Creates a new Menu object with the specified description. */
    private Menu(String description) {
        this.description = description;
    }

    /** Adds a dish to the menu. */
    public void ajoute(PlatAuMenu p) {
        plats.add(p);
    }

    /** Associates a recipe with a dish on the menu. */
    public static void associerRecetteAuPlat(PlatAuMenu plat, Recette recette) {
        recettesParPlat.put(plat.getCode(), recette);
    }

    /** Retrieves the recipe associated with a given dish on the menu. */
    public Recette getRecettePourPlat(PlatAuMenu plat) throws MenuException {
        Recette recette = recettesParPlat.get(plat.getCode());
        if (recette == null) {
            throw new MenuException("Aucune recette associée à ce plat: " + plat.getCode());
        }
        return recette;
    }

    /** Sets the current position in the menu. */
    public void position(int i) {
        courant = i;
    }

    /** The current menu object */
    public static Menu menu;

    /** Returns the current menu object. If there is no current menu object, creates one with the specified description. */
    public static Menu getMenu(String description) {
        if (menu == null) {
            menu = new Menu(description);
        }
        return menu;
    }

    /** Returns the current dish on the menu. */
    public PlatAuMenu platCourant() {
        return plats.get(courant);
    }

    /** Sets the current position to the next dish on the menu. */
    public void positionSuivante() throws MenuException {
        if (courant + 1 >= plats.size())
            throw new MenuException("On depasse le nombre maximal de plats");
        courant++;
    }

    /** Sets the current position to the previous dish on the menu. */
    public void positionPrecedente() throws MenuException {
        if (courant - 1 < 0)
            throw new MenuException("On depasse le nombre minimal de plats");
        courant--;
    }

    /** Returns the current position in the menu. */
    public int getPosition() {
        return courant;
    }

    /** Returns the description of the menu. */
    public String getDescription() {
        return description;
    }

    /** Returns the dish on the menu with the specified code. */
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
