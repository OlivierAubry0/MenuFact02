package ingredients.etat;

public abstract class IngredientEtat {
    protected String unit;

    public IngredientEtat(String unit){
        this.unit = unit;
    }

    @Override

    public String toString(){
        return "unit: '" + unit +"\'";
    }
}
