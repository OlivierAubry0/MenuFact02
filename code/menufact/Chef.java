package menufact;
import ingredients.exceptions.IngredientsAuMenu;
import menufact.factory.plats.PlatChoisi;
import menufact.state.EnCours;
import menufact.state.Servie;
import menufact.state.StatePreparation;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import ingredients.IngredientInventaire;
import menufact.state.Terminee;

public class Chef {
    private String nom;

    private StatePreparation state;
    private Queue<PlatChoisi> platsChoisis = new LinkedList<>();
    private static Chef instance = null;
    private Chef(String nom){this.nom = nom;}
    public static Chef getInstance(String nom){
        if (instance == null){
            instance = new Chef(nom);
        }
        return instance;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){this.nom = nom;}
    public PlatChoisi cuisiner(PlatChoisi plat){
        verifierIngredient(plat);
        preparer(plat);
        servir(plat);

        return plat;
    }
    private void verifierIngredient(PlatChoisi plat){
     state = new EnCours(plat);
     state.enCours();
    }
    private void preparer(PlatChoisi plat){
    state = new EnCours(plat);
    state.terminee();
    }
    private PlatChoisi servir(PlatChoisi plat){
        state = new Servie(plat);
        state.servie();


        return plat;
    }
    @Override
    public String toString(){return "Chef: {" + "Nom: " + nom + "}";};
}
