package menufact.factory.plats;

import menufact.factory.exceptions.PlatException;
import menufact.Builder.Recette;
import menufact.singleton.*;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;

    /**
     * Constructs a new PlatAuMenu instance with the given code, description, and price.
     *
     * @param code the code of the dish
     * @param description the description of the dish
     * @param prix the price of the dish
     */
    public PlatAuMenu(Integer code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
    }

    /**
     * Returns the code of the dish.
     *
     * @return the code of the dish
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code of the dish.
     *
     * @param code the new code of the dish
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Returns the description of the dish.
     *
     * @return the description of the dish
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the dish.
     *
     * @param description the new description of the dish
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of the dish.
     *
     * @return the price of the dish
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Sets the price of the dish.
     *
     * @param prix the new price of the dish
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Returns the recipe of the dish.
     *
     * @param code the code of the dish whose recipe is to be retrieved
     * @return the recipe of the dish
     */
    public Recette getRecette(int code) {
        Menu menu = Menu.getMenu("description");
        try {
            return menu.getRecettePourPlat(menu.getPlatAuMenu(code));
        } catch (menufact.exceptions.MenuException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a string representation of the dish.
     *
     * @return a string representation of the dish
     */
    @Override
    public String toString() {
        return "Code: " + code + ", Description: " + description + ", Prix: " + prix ;
    }
}
