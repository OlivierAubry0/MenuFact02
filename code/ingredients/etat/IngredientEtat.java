package ingredients.etat;

public abstract class IngredientEtat {
    private EtatIngredient etat;
    private String unit;
    /**
     * Creates a new IngredientEtat object with the given state.
     * @param etat The state of the ingredient.
     */


    public IngredientEtat(EtatIngredient etat) {
        this.etat = etat;
    }
    /**
     * Returns the state of the ingredient.
     * @return The state of the ingredient.
     */
    public EtatIngredient getEtat() {
        return etat;
    }
}

