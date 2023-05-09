package menufact.factory.plats;

import menufact.state.StatePreparation;
import menufact.Builder.*;

public class PlatChoisi extends PlatAuMenu{
    private PlatAuMenu plat;
    private int quantite;
    private StatePreparation state;
    /**
     * Constructs a PlatChoisi object with the given dish from the menu, quantity, and preparation state.
     *
     * @param plat the dish from the menu
     * @param quantite the quantity of the dish
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) {
        super(plat.getCode(), plat.getDescription(), plat.getPrix());
        this.quantite = quantite;
        this.state = state;
    }




    /**
     * Returns the dish from the menu of the PlatChoisi object.
     *
     * @return the dish from the menu
     */
    public PlatAuMenu getPlat(){
        return plat;
    }

    /**
     * Returns the quantity of the dish of the PlatChoisi object.
     *
     * @return the quantity of the dish
     */
    public int getQuantite() {
        return this.quantite;
    }

    /**
     * Sets the quantity of the dish of the PlatChoisi object.
     *
     * @param quantite the new quantity of the dish
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Returns the preparation state of the dish of the PlatChoisi object.
     *
     * @return the preparation state of the dish
     */
    public StatePreparation getState() {
        return state;
    }
    /**
     * Sets the preparation state of the dish of the PlatChoisi object.
     *
     * @param state the new preparation state of the dish
     */
    public void setState(StatePreparation state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", code=" + getCode() +
                ", description=" + getDescription() +
                ", prix=" + getPrix() +
                ", recette=" + getRecette(getCode()) +
                ", state=" + getState() +
                '}';
    }
}
