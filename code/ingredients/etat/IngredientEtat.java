package ingredients.etat;

public abstract class IngredientEtat {
    private String unite;

    public IngredientEtat(String unite) {
        this.unite = unite;
    }

    public String getUnite() {
        return unite;
    }
}
