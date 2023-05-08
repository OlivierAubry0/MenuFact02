package menufact.observer.MVC;

import menufact.observer.Facture;

public class FactureControleur {
    private Facture facture;
    private FactureVue vue;

    public FactureControleur() {
        facture = new Facture("Facture");
        vue = new FactureVue(this);
        facture.addObserver(vue);
    }

    public void genererFacture() {
        facture.genererFacture();
    }

    public void run() {
        vue.show();
    }
}

