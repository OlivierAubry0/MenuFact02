package menufact.factory.plats;

import menufact.factory.exceptions.PlatException;
import menufact.factory.plats.PlatAuMenu;

public class PlatEnfant extends PlatAuMenu {
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, double proportion) throws PlatException {
        super(code, description, prix);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }

    @Override
    public void AfficherPlat() {
        System.out.println("Plat enfant");
    }
}
