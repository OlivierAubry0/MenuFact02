package menufact.state;

public abstract class StatePreparation {
    protected menufact.factory.plats.PlatChoisi plat;
    protected String state;

    public StatePreparation(menufact.factory.plats.PlatChoisi plat){
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
