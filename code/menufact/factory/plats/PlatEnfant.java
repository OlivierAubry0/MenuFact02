package menufact.factory.plats;

import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatAuMenu;
import menufact.Builder.Recette;

public class PlatEnfant extends PlatAuMenu {
    private double proportion;

    public PlatEnfant(Integer code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Proportion: " + proportion;
    }
}

