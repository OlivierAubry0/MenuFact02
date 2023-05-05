package menufact.state;

import menufact.plats.PlatChoisi;
public class Commande extends StatePreparation{
    public Commande(PlatChoisi plat){
        super(plat);
        this.state = "Commande";
    }

    @Override
    public void commande(){
        this.plat.setState(new Commande(this.plat));
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

    }
}
