package ingredients.etat;

public abstract class IngredientEtat {
    private EtatIngredient etat;
    private String unit;



    public IngredientEtat(EtatIngredient etat) {
        this.etat = etat;
    }

    public EtatIngredient getEtat() {
        return etat;
    }
}

