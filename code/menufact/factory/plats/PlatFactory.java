package menufact.factory.plats;

import menufact.Builder.Recette;
import menufact.factory.exceptions.PlatException;

public class PlatFactory {
    public PlatAuMenu createPlat(Integer code, String description, double prix, Recette recette) {
        return new PlatAuMenu(code, description, prix);
    }

    public PlatSante createPlatSante(Integer code, String description, double prix, Recette recette, double calories, double gras, double cholesterol) {
        return new PlatSante(code, description, prix, calories, gras, cholesterol);
    }

    public PlatEnfant createPlatEnfant(Integer code, String description, double prix, Recette recette, double proportion) {
        return new PlatEnfant(code, description, prix, proportion);
    }
}

