package ingredients.etat;

public abstract class IngredientEtat {

    protected String unit;

    public IngredientEtat(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    /**
     * @return les unites de l'ingredient
     */
    @Override
    public String toString() {
        return "unit : '" + unit + '\'';
    }
}