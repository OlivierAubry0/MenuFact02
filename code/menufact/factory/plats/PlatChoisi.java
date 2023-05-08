package menufact.factory.plats;

import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.Plat;
import menufact.factory.plats.PlatAuMenu;
import menufact.state.Commande;
import menufact.state.StatePreparation;

public class PlatChoisi extends PlatAuMenu{
    private PlatAuMenu plat;
    private int quantite;
    private StatePreparation state;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        super(plat.getCode(), plat.getDescription(), plat.getPrix(), plat.getRecette());
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public StatePreparation getState() {
        return state;
    }

    public void setState(StatePreparation state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }
}

