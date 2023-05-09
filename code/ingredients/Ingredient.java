package ingredients;
<<<<<<< Updated upstream
import ingredients.etat.IngredientEtat;



public interface Ingredient {
    String getNom();

    void setNom(String nom);

    String getDescription();
=======

public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;

    public String getNom() {
        return nom;
    }
>>>>>>> Stashed changes

    void setDescription(String description);

    TypeIngredient getType();

    void setType(TypeIngredient type);

    IngredientEtat getEtat();

    void setEtat(IngredientEtat etat);
}
