package menufact.factory.plats;

import menufact.factory.plats.exceptions.PlatException;
import ingredients.IngredientsAuMenu;
import java.util.Map;
import java.util.HashMap;
public class PlatAuMenu implements Plat{
    private int code;
    private String description;
    private double prix;
    private Map<IngredientsAuMenu, Integer> ingredients = new HashMap<>();
    public Map<IngredientsAuMenu, Integer> getIngredients() { return ingredients; }

    public PlatAuMenu(int code, String description, double prix) throws PlatException {
        this.code = code;
        this.description = description;
        if(prix >=0) {
            this.prix = prix;
        }
        else{
            throw new PlatException("number below zero");
        }
    }
    public void setIngredients(IngredientsAuMenu ingredient, Integer quantity) {
        this.ingredients.put(ingredient, quantity);
    }

    public PlatAuMenu() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
