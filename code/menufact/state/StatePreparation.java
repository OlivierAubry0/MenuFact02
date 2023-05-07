package menufact.state;

import menufact.factory.plats.PlatChoisi;

public abstract class StatePreparation {
    protected PlatChoisi plat;
    protected String state;

    public StatePreparation(PlatChoisi plat){
        this.plat = plat;
    }

    public abstract void commande();
    public abstract void impossible();
    public abstract void servie();
    public abstract void terminee();
    public abstract void enCours();

    @Override
    public String toString(){
        return "etat: '" + state +"'";
    };

}
