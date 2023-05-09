package menufact.state;

import menufact.factory.plats.PlatChoisi;

public class Terminee extends StatePreparation{

    public Terminee(PlatChoisi plat){
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
