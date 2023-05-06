package menufact.factory.plats;

import ingredients.IngredientsAuMenu;
import java.util.Map;

public interface Plat {
    /*factory design pattern*/
    Plat createPlat();
    Map<IngredientsAuMenu, Integer> getIngredients();
}
