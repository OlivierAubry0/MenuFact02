package menufact.factory.plats;

import menufact.factory.exceptions.PlatException;
import menufact.Builder.Recette;
import menufact.singleton.*;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;

    public PlatAuMenu(Integer code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
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

    public Recette getRecette(int code) {
        Menu menu = Menu.getMenu("description");
        try {
            return menu.getRecettePourPlat(menu.getPlatAuMenu(code));
        } catch (menufact.exceptions.MenuException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Description: " + description + ", Prix: " + prix + ", Recette: " + getRecette(code);
    }
}
