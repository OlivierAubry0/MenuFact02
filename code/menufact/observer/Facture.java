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

    public Facture(String description, Client client, Chef chef) {
        this.date = new Date();
        this.description = description;
        this.client = client;
        this.chef = chef;
        this.etat = new FactureEtatOuverte();
        this.platchoisi = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
    public void associerClient (Client client)
    {
        this.client = client;
    }
    public void associerChef(Chef chef) {
        this.chef = chef;
    }
    public double sousTotal()
    {
        double soustotal=0;
        for (PlatChoisi p : platchoisi)
            soustotal += p.getQuantite() * p.getPrix();
        return soustotal;
    }
    public double total(){
        return sousTotal()+tps()+tvq();
    }
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
    public String genererFacture() {
        StringBuilder factureGenere = new StringBuilder();
        int i = 1;

        factureGenere.append("Facture generee.\n" +
                "Date:" + date + "\n" +
                "Description: " + description + "\n" +
                "Client:" + client.getNom() + "\n" +
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
    public ArrayList<PlatChoisi> getPlats() {
        return this.platchoisi;
    }
}
