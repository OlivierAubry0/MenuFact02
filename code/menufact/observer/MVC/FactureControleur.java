package menufact.observer.MVC;

import menufact.observer.*;

public class FactureControleur {
    private Facture facture;
    private FactureVue vue;

    public FactureControleur() {
        facture = new Facture("Facture");
        vue = new FactureVue(this);
        Observable observable = new Observable();
        observable.registerObserver(vue);
    }

    public void genererFacture() {
        String factureGeneree = facture.genererFacture();
        vue.updateTextArea(factureGeneree);
        facture.notifyObservers(factureGeneree);
    }

    public void run() {
        vue.show();
    }
}

