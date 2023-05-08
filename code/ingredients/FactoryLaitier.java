package ingredients;

public class FactoryLaitier implements FactoryIngredient {
    public FactoryLaitier() {}

    @Override
    public Laitier createIngredients(){
        return new Laitier();
    }
}
