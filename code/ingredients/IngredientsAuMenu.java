package ingredients;

public abstract class IngredientsAuMenu implements Ingredient {
    private String nom;
    private String description;
    protected TypeIngredient type;

    public IngredientsAuMenu() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public TypeIngredient getType() {
        return type;
    }

    public void setType(TypeIngredient type) {
        this.type = type;
    }

    /**
     * @return le nom, la description, l'etat et le type de l'ingredient
     */
    @Override
    public String toString() {
        return "Ingredient{" +
                "nom : '" + nom + '\'' +
                ", description : '" + description + '\'' +
                ", " +
                ", type : '" + type +
                "'}";
    }
}
