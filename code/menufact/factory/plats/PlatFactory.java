package menufact.factory.plats;

import menufact.Builder.Recette;
import menufact.factory.exceptions.PlatException;

/**
 * The PlatFactory class is a factory class for creating PlatAuMenu objects.
 * It provides methods for creating different types of plats.
 */
public class PlatFactory {

    /**
     * Creates a PlatAuMenu object with the given code, description, and price.
     * @param code the code of the plat
     * @param description the description of the plat
     * @param prix the price of the plat
     * @return the created PlatAuMenu object
     */
    public PlatAuMenu createPlat(Integer code, String description, double prix) {
        return new PlatAuMenu(code, description, prix);
    }

    /**
     * Creates a PlatSante object with the given code, description, price, recette, calories, gras, and cholesterol.
     * @param code the code of the plat
     * @param description the description of the plat
     * @param prix the price of the plat
     * @param recette the recipe of the plat
     * @param calories the number of calories in the plat
     * @param gras the amount of fat in the plat
     * @param cholesterol the amount of cholesterol in the plat
     * @return the created PlatSante object
     */
    public PlatSante createPlatSante(Integer code, String description, double prix, Recette recette, double calories, double gras, double cholesterol) {
        return new PlatSante(code, description, prix, calories, gras, cholesterol);
    }

    /**
     * Creates a PlatEnfant object with the given code, description, price, recette, and proportion.
     * @param code the code of the plat
     * @param description the description of the plat
     * @param prix the price of the plat
     * @param recette the recipe of the plat
     * @param proportion the proportion of the plat
     * @return the created PlatEnfant object
     */
    public PlatEnfant createPlatEnfant(Integer code, String description, double prix, Recette recette, double proportion) {
        return new PlatEnfant(code, description, prix, proportion);
    }
}
