package menufact.factory.plats;

import menufact.Builder.Recette;
import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatAuMenu;

public class PlatSante extends PlatAuMenu {
    private double calories;
    private double gras;
    private double cholesterol;

    /**
     * Constructs a new PlatSante object with a code, a description, a price, and nutritional values.
     *
     * @param code        the code of the dish
     * @param description the description of the dish
     * @param prix        the price of the dish
     * @param calories    the number of calories in the dish
     * @param gras        the amount of fat in the dish
     * @param cholesterol the amount of cholesterol in the dish
     */
    public PlatSante(Integer code, String description, double prix, double calories, double gras, double cholesterol) {
        super(code, description, prix);
        this.calories = calories;
        this.gras = gras;
        this.cholesterol = cholesterol;
    }

    /**
     * Gets the number of calories in the dish.
     *
     * @return the number of calories
     */
    public double getKcal() {
        return calories;
    }

    /**
     * Gets the amount of cholesterol in the dish.
     *
     * @return the amount of cholesterol
     */
    public double getChol() {
        return cholesterol;
    }

    /**
     * Gets the amount of fat in the dish.
     *
     * @return the amount of fat
     */
    public double getGras() {
        return gras;
    }

    /**
     * Returns a string representation of this PlatSante object.
     *
     * @return a string representation of the PlatSante object
     */
    @Override
    public String toString() {
        return super.toString() + ", Calories: " + calories + ", Gras: " + gras + ", Cholesterol: " + cholesterol;
    }
}




