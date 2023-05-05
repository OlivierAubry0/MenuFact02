package menufact.state;

public class Terminee extends StatePreparation{

    public Terminee(menufact.plats.PlatChoisi plat){
        super(plat);
        this.state = "Terminee";

    }


    @Override
    public void commande(){
    }
    @Override
    public void enCours() {

    }

    @Override
    public void terminee() {
        this.plat.setState(new Terminee(this.plat));
    }

    @Override
    public void servie() {

    }

    @Override
    public void impossible() {

    }
}
