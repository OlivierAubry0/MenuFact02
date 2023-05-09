package menufact.observer.MVC;

import menufact.Client;
import menufact.observer.*;

public class FactureControleur {
    private Facture facture;
    private FactureVue vue;

    private static Client client;

    public FactureControleur() {
        facture = new Facture("Facture");
        vue = new FactureVue(this);
        Observable observable = new Observable();
        observable.registerObserver(vue);
    }

    public void genererFacture() {
        String factureGeneree = facture.genererFacture();
        facture.associerClient(client);
        vue.updateTextArea(factureGeneree);
        facture.notifyObservers(factureGeneree);
    }

    public void run() {
        vue.show();
    }
}

