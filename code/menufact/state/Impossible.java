package menufact.state;

import menufact.factory.plats.PlatChoisi;

public class Impossible extends StatePreparation{

    public Impossible(PlatChoisi plat){
        super(plat);
        this.state = "Impossible";


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

    }

    @Override
    public void impossible() {
        this.plat.setState(new Impossible(this.plat));
    }
}
