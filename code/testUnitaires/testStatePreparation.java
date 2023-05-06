package testUnitaires;

import menufact.factory.plats.PlatChoisi;
import menufact.factory.plats.PlatAuMenu;
import menufact.state.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testStatePreparation {
    private Commande commande;
    private Servie servie;
    private Terminee terminee;
    private Impossible impossible;
    private EnCours enCours;


    @BeforeEach
    public void setup(){
        PlatChoisi platChoisi = new PlatChoisi(new PlatAuMenu(), 2);
        commande = new Commande(platChoisi);
        servie = new Servie(platChoisi);
        terminee = new Terminee(platChoisi);
        impossible = new Impossible(platChoisi);
        enCours = new EnCours(platChoisi);
    }

    @Test

    void commande(){

        Assertions.assertTrue(commande instanceof Commande);
    }

    @Test

    void servie(){
        Assertions.assertTrue(servie instanceof Servie);
    }

    @Test

    void terminee(){
        Assertions.assertTrue(terminee instanceof Terminee);
    }

    void impossible(){
        Assertions.assertTrue(impossible instanceof Impossible);
    }
    @Test

    void enCours(){
        Assertions.assertTrue(enCours instanceof EnCours);
    }

}
