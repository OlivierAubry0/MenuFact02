package menufact.state;

public class Servie extends StatePreparation{

    public Servie(menufact.factory.plats.PlatChoisi plat){
        super(plat);
        this.state = "Servie";
    }

    @Override
    public void commande(){
    }
    @Override
    public void enCours() {

    }

    @Override
    public void terminee() {

    }

    @Override
    public void servie() {
        this.plat.setState(new Servie(this.plat));
    }

    @Override
    public void impossible() {

    }
}
