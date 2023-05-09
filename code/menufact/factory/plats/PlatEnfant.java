package menufact.factory.plats;

import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatAuMenu;
import menufact.Builder.Recette;

public class PlatEnfant extends PlatAuMenu {
    private double proportion;

    /**
     * Creates a new PlatEnfant object with the specified code, description, price and proportion.
     *
     * @param code        the code of the PlatEnfant
     * @param description the description of the PlatEnfant
     * @param prix        the price of the PlatEnfant
     * @param proportion  the proportion of the PlatEnfant
     */
    public PlatEnfant(Integer code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    /**
     * Returns the proportion of the PlatEnfant.
     *
     * @return the proportion of the PlatEnfant
     */
    public double getProportion() {
        return proportion;
    }

    /**
     * Returns a string representation of the PlatEnfant.
     *
     * @return a string representation of the PlatEnfant
     */
    @Override
    public String toString() {
        return super.toString() + ", Proportion: " + proportion;
    }
}
