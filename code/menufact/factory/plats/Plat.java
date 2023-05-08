package menufact.factory.plats;

import ingredients.IngredientsAuMenu;

import java.util.Map;

public interface Plat {
    int getCode();

    void setCode(int code);

    String getDescription();

    void setDescription(String description);

    double getPrix();

    void setPrix(double price);
}

