package ingredients;



public interface Ingredient {
    String getNom();

    void setNom(String nom);

    String getDescription();

    void setDescription(String description);

    TypeIngredient getType();

    void setType(TypeIngredient type);
}
