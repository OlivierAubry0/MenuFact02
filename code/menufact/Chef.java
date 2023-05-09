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

/**

 The Chef class represents a chef who is responsible for preparing dishes in a restaurant.

 It implements the Observer interface to receive notifications when an ingredient is out of stock.
 */
public class Chef implements Observer {

    /** The name of the chef. */
    private String nom;

    /** The current state of the chef's preparation. */
    private StatePreparation state;

    /** The queue of dishes to be prepared by the chef. */
    private Queue<PlatChoisi> platsChoisis = new LinkedList<>();

    /** The singleton instance of the Chef class. */
    private static Chef instance = null;

    /** A flag indicating whether the chef has received a notification. */
    private boolean notificationReceived = false;

    /**

     Private constructor to prevent multiple instances of the Chef class.
     @param nom The name of the chef.
     */
    private Chef(String nom) {
        this.nom = nom;
    }
    /**

     Gets the singleton instance of the Chef class.
     @param nom The name of the chef.
     @return The singleton instance of the Chef class.
     */
    public static Chef getInstance(String nom) {
        if (instance == null) {
            instance = new Chef(nom);
        }
        return instance;
    }
    /**

     Gets the name of the chef.
     @return The name of the chef.
     */
    public String getNom() {
        return this.nom;
    }
    /**

     Sets the name of the chef.
     @param nom The name of the chef.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**

     Prepares a dish by verifying ingredients and then cooking it.

     @param plat The dish to prepare.

     @return The prepared dish.
     */
    public PlatChoisi cuisiner(PlatChoisi plat) {
        verifierIngredient(plat);
        preparer(plat);

        return plat;
    }

    /**

     Verifies that there are enough ingredients to prepare a dish.
     @param plat The dish to verify.
     */
    private void verifierIngredient(PlatChoisi plat) {
        state = new EnCours(plat);
        state.enCours();
    }
    /**

     Prepares a dish by cooking it.
     @param plat The dish to prepare.
     */
    private void preparer(PlatChoisi plat) {
        state = new EnCours(plat);
        state.terminee();
    }
    /**

     Serves a dish by marking it as served.
     @param platChoisi The dish to serve.
     */
    public void servir(PlatChoisi platChoisi) {
        platChoisi.setState(new Servie(platChoisi));
    }
    /**

     Gets a string representation of the chef.
     @return A string representation of the chef.
     */
    @Override
    public String toString() {
        return "Chef: {" + "Nom: " + nom + "}";
    }
    /**

     Receives a notification from an Observable object.
     @param message The message sent by the Observable object.
     */
    @Override
    public void actualiser(String message) {
        System.out.println("Chef " + nom + " a reçu une notification: " + message);
        notificationReceived = true;
    }
    /**

     Gets a flag indicating whether the chef has received a notification.
     @return A flag indicating whether the chef has received a notification.
     */
    public boolean hasReceivedNotification() {
        return notificationReceived;
    }

    /**

     Resets notifications for the chef

     */
    public void resetNotificationIndicator() {
        notificationReceived = false;
    }
}
