package menufact.factory.plats;

import menufact.state.StatePreparation;
import menufact.Builder.*;

public class PlatChoisi extends PlatAuMenu{
    private PlatAuMenu plat;
    private int quantite;
    private StatePreparation state;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        super(plat.getCode(), plat.getDescription(), plat.getPrix());
        this.quantite = quantite;
        this.state = state;
    }

    public PlatAuMenu getPlat(){
        return this.plat;
    }
    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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
                ", code=" + getCode() +
                ", description=" + getDescription() +
                ", prix=" + getPrix() +
                ", recette=" + getRecette(getCode()) +
                ", state=" + getState() +
                '}';
    }
}
