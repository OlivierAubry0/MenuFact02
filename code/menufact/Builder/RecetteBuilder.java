package menufact.Builder;

import ingredients.Ingredient;


public interface RecetteBuilder {
    RecetteBuilder addIngredient(Ingredient ingredient, int quantite);
    Recette build();
}

