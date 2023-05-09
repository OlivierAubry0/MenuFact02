package ingredients;

import ingredients.etat.EtatIngredient;

public abstract class Ingredient {
    private String nom;
    private TypeIngredient typeIngredient;
    private EtatIngredient etatIngredient;
    private double quantite;

    public Ingredient(String nom, TypeIngredient typeIngredient, EtatIngredient etatIngredient, double quantite) {
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

    public EtatIngredient getEtatIngredient() {
        return etatIngredient;
    }

    public void setEtatIngredient(EtatIngredient etatIngredient) {
        this.etatIngredient = etatIngredient;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
}
