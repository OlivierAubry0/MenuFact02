package menufact.observer.facture;

public class FactureEtatOuverte implements FactureEtat {
    @Override
    public boolean changerEtat(FactureEtat etat) {
        return etat instanceof FactureEtatPayee || etat instanceof FactureEtatFermee;
    }
}
