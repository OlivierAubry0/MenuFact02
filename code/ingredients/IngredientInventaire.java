package ingredients;

import ingredients.exceptions.IngredientException;
import ingredients.exceptions.IngredientsAuMenu;
import java.util.Map;

public class IngredientInventaire {
    private IngredientInventaire ingredientInventaire;

    private static IngredientInventaire inventaire;
    private int quantite;

    public IngredientInventaire() {
        this.ingredientInventaire = ingredientInventaire;
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    public static IngredientInventaire getInventaire() {
        if (inventaire == null)
            inventaire = new IngredientInventaire();
        return inventaire;
    }

}
