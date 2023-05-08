package ingredients;

public class FactoryLegume implements FactoryIngredient {
    public FactoryLegume() {}

    public Legume createIngredients(){
        return new Legume();
    }
}