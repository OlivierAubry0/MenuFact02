package menufact.observer.facture;

public class FactureEtatPayee implements FactureEtat {
    @Override
    public boolean changerEtat(FactureEtat etat) {
        return etat instanceof FactureEtatFermee;
    }
}
