package menufact.observer;

import menufact.Chef;
import menufact.Client;
import menufact.observer.exceptions.FactureException;
import menufact.factory.plats.PlatChoisi;
import menufact.factory.exceptions.PlatException;
import menufact.state.EnCours;
import menufact.state.Terminee;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Facture extends Observable {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi;
    private Client client;
    private Chef chef;
    private List<Observer> observers;
    private ArrayList<PlatChoisi> plats;
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     * Constructs a bill with the specified description, client, and chef.
     * @param description the description of the bill
     * @param client the client for whom the bill is intended
     * @param chef the chef responsible for cooking the dishes of the bill
     */
    public Facture(String description, Client client, Chef chef) {
        this.date = new Date();
        this.description = description;
        this.client = client;
        this.chef = chef;
        this.etat = new FactureEtatOuverte();
        this.platchoisi = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Associates a client with the bill.
     * @param client the client to associate with the bill
     */
    public void associerClient (Client client) {
        this.client = client;
    }

    /**
     * Associates a chef with the bill.
     * @param chef the chef to associate with the bill
     */
    public void associerChef(Chef chef) {
        this.chef = chef;
    }

    /**
     * Calculates the subtotal of the bill.
     * @return the subtotal of the bill
     */
    public double sousTotal() {
        double soustotal = 0;
        for (PlatChoisi p : platchoisi)
            soustotal += p.getQuantite() * p.getPrix();
        return soustotal;
    }

    /**
     * Calculates the total of the bill including taxes.
     * @return the total of the bill including taxes
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     * Calculates the amount of the Quebec Sales Tax on the bill.
     * @return the amount of the Quebec Sales Tax on the bill
     */
    private double tps(){
        return TPS*sousTotal();
    }

    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }
    public void payer() throws FactureException {
        if (etat.changerEtat(new FactureEtatPayee())) {
            etat = new FactureEtatPayee();
        } else {
            throw new FactureException("La facture ne peut pas etre payee");
        }
    }
    public void fermer() throws FactureException {
        if (etat.changerEtat(new FactureEtatFermee())){
            etat = new FactureEtatFermee();

        } else {
            throw new FactureException("La facture ne peut pas etre fermee");
        }
    }

    public void ouvrir() throws FactureException
    {
        if (etat.changerEtat(new FactureEtatOuverte()))
            etat = new FactureEtatOuverte();
        else
            throw new FactureException("La facture ne peut pas être reouverte.");
    }
    /**

     Returns the state of the bill.
     @return The state of the bill.
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    public Facture(String description) {
        date = new Date();
        etat = new FactureEtatOuverte();
        this.description = description;
        this.platchoisi = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
    /**

     Adds a dish to the bill.
     @param p The dish to add.
     @throws FactureException if the bill is closed or paid, or if there is no chef or if the dish is null.
     @throws PlatException if the dish is null.
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException {
        if (etat instanceof FactureEtatFermee || etat instanceof FactureEtatPayee){
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
        }
        if (p == null){
            throw new PlatException("Le plat choisi ne peut pas etre null.");
        }
        if (chef == null){
            throw new FactureException("Il ne peut pas y avoir aucun chef pour ajouter un plat.");
        }
        if (etat instanceof FactureEtatOuverte)
            this.platchoisi.add(p);
        p.setState(new EnCours(p));
        notifyObservers("Un nouveau plat a été ajouté:" + p.getDescription());
    }

    @Override
    public String toString() {
        return "Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**

     Generates a bill as a string.

     @return The generated bill as a string.
     */
    public String genererFacture() {
        StringBuilder factureGenere = new StringBuilder();
        int i = 1;
        factureGenere.append("Cuisine par: " + chef.getNom() + "\n" );
        factureGenere.append("Facture generee.\n" +
                "Date:" + date + "\n" +
                "Description: " + description + "\n" +
                "Client: " + client.getNom() + "\n" +
                "Les plats commandes:\n");

        factureGenere.append("Seq   Plat         Prix   Quantite\n");
        for (PlatChoisi plat : platchoisi) {
            factureGenere.append(i + "     " + plat.getDescription() + "  " + plat.getPrix() + "      " + plat.getQuantite() + "\n");
            i++;
            plat.setState(new Terminee(plat));
        }

        factureGenere.append("          TPS:               " + tps() + "\n");
        factureGenere.append("          TVQ:               " + tvq() + "\n");
        factureGenere.append("          Le total est de:   " + total() + "\n");

        return factureGenere.toString();
    }

    /**

     Returns the list of dishes on the bill.
     @return The list of dishes on the bill.
     */
    public ArrayList<PlatChoisi> getPlats() {
        return this.platchoisi;
    }
}
