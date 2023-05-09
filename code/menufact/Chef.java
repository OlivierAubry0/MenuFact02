package menufact;
import ingredients.Ingredient;

import menufact.observer.Observer;
import menufact.factory.plats.PlatChoisi;
import menufact.state.EnCours;
import menufact.state.Servie;
import menufact.state.StatePreparation;
import menufact.observer.Observer;
import inventaire.Inventaire;

import java.util.Queue;
import java.util.LinkedList;

public class Chef implements Observer {
    private String nom;

    private StatePreparation state;
    private Queue<PlatChoisi> platsChoisis = new LinkedList<>();
    private static Chef instance = null;
    private Chef(String nom){this.nom = nom;}
    private boolean notificationReceived = false;

    public static Chef getInstance(String nom) {
        if (instance == null) {
            instance = new Chef(nom);
        }
        return instance;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public PlatChoisi cuisiner(PlatChoisi plat) {
        verifierIngredient(plat);
        preparer(plat);

        return plat;
    }

    private void verifierIngredient(PlatChoisi plat) {
        state = new EnCours(plat);
        state.enCours();
    }

    private void preparer(PlatChoisi plat) {
        state = new EnCours(plat);
        state.terminee();
    }

    public void servir(PlatChoisi platChoisi) {
        platChoisi.setState(new Servie(platChoisi));
    }

    @Override
    public String toString() {
        return "Chef: {" + "Nom: " + nom + "}";
    }

    @Override
    public void actualiser(String message) {
        System.out.println("Chef " + nom + " a reçu une notification: " + message);
        notificationReceived = true;
    }
    public boolean hasReceivedNotification() {
        return notificationReceived;
    }
    public void resetNotificationIndicator() {
        notificationReceived = false;
    }
}
