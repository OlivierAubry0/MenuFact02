package menufact.factory.plats;

import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.Plat;
import menufact.factory.plats.PlatAuMenu;
import menufact.state.Commande;
import menufact.state.StatePreparation;

public class PlatChoisi extends Plat {
    private PlatAuMenu plat;
    private int quantite;
    private StatePreparation state;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.state = new Commande(this);
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

    @Override
    public void AfficherPlat() {
        System.out.println("Plat choisi");
    }
}
