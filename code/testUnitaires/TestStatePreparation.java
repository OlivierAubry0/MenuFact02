package testUnitaires;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.Laitier;
import ingredients.Legume;
import ingredients.etat.EtatIngredient;
import menufact.Builder.Recette;
import menufact.Builder.RecetteBuilder;
import menufact.factory.plats.PlatChoisi;
import menufact.factory.plats.PlatAuMenu;
import menufact.singleton.Menu;
import menufact.state.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStatePreparation {
    private Commande commande;
    private Servie servie;
    private Terminee terminee;
    private Impossible impossible;
    private EnCours enCours;


    @BeforeEach
    public void setup(){
        Ingredient Tomate = new Legume("Tomate", EtatIngredient.SOLIDE, 150);
        Ingredient Fromage = new Laitier("Fromage", EtatIngredient.SOLIDE, 25);
        Ingredient Sauce = new Epice("Sauce", EtatIngredient.LIQUIDE, 5);
        RecetteBuilder pizzaBuilder = new RecetteBuilder();
        pizzaBuilder.addIngredient(Tomate, 3)
                    .addIngredient(Fromage, 20)
                    .addIngredient(Sauce, 1);
        Recette pizza = pizzaBuilder.build();
        PlatChoisi platChoisi = new PlatChoisi(new PlatAuMenu(3,"Mmm",100.59), 2);
        Menu.associerRecetteAuPlat(platChoisi,pizza);
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
