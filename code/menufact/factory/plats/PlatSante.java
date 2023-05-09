package menufact.factory.plats;

import menufact.Builder.Recette;
import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatAuMenu;

public class PlatSante extends PlatAuMenu {
    private double calories;
    private double gras;
    private double cholesterol;

    public PlatSante(Integer code, String description, double prix, double calories, double gras, double cholesterol) {
        super(code, description, prix);
        this.calories = calories;
        this.gras = gras;
        this.cholesterol = cholesterol;
    }

    public double getKcal() {
        return calories;
    }

    public double getChol() {
        return cholesterol;
    }

    public double getGras() {
        return gras;
    }

    @Override
    public String toString() {
        return super.toString() + ", Calories: " + calories + ", Gras: " + gras + ", Cholesterol: " + cholesterol;
    }
}




