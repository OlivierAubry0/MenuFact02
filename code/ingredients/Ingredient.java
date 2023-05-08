package ingredients;
import ingredients.etat.IngredientEtat;



public interface Ingredient {
    String getNom();

    void setNom(String nom);

    String getDescription();

    void setDescription(String description);

    TypeIngredient getType();

    void setType(TypeIngredient type);

    IngredientEtat getEtat();

    void setEtat(IngredientEtat etat);
}
