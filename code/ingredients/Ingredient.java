package ingredients;

import ingredients.etat.IngredientEtat;
public abstract class Ingredient {
    private String nom;
    private TypeIngredient typeIngredient;
    private IngredientEtat etatIngredient;
    private double quantite;

    public Ingredient(String nom, TypeIngredient typeIngredient, IngredientEtat etatIngredient, double quantite) {
        this.nom = nom;
        this.typeIngredient = typeIngredient;
        this.etatIngredient = etatIngredient;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    public IngredientEtat getEtatIngredient() {
        return etatIngredient;
    }

    public void setEtatIngredient(IngredientEtat etatIngredient) {
        this.etatIngredient = etatIngredient;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
}
