package menufact.state;

import menufact.factory.plats.PlatChoisi;

public class EnCours extends StatePreparation{

    public EnCours(PlatChoisi plat){
        super(plat);
        this.state = "enCours";
    }

    @Override
    public void commande(){
    }
    @Override
    public void enCours() {
        this.plat.setState(new EnCours(this.plat));
    }

    @Override
    public void terminee() {

    }

    @Override
    public void servie() {

    }

    @Override
    public void impossible() {

    }
}
