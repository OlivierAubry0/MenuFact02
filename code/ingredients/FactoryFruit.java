package ingredients;

public class FactoryFruit implements FactoryIngredient {
    public FactoryFruit() {}

    @Override
    public Fruit createIngredients(){
        return new Fruit();
    }
}
