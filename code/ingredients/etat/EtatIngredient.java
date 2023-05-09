
package ingredients.etat;

public enum EtatIngredient {
    SOLIDE(new IngredientSolide()),
    LIQUIDE(new IngredientLiquide());

    private final IngredientSolide solide;
    private final IngredientLiquide liquide;

    EtatIngredient(IngredientSolide solide) {
        this.solide = solide;
        this.liquide = null;
    }

    EtatIngredient(IngredientLiquide liquide) {
        this.solide = null;
        this.liquide = liquide;
    }

    public IngredientSolide getSolide() {
        return solide;
    }

    public IngredientLiquide getLiquide() {
        return liquide;
    }
}
