package menufact.factory.plats;

import menufact.Builder.Recette;
import menufact.factory.exceptions.PlatException;

public class PlatFactory {
    public static PlatAuMenu createPlat(String type, int code, String description, double prix, Recette recette, double proportion, double kcal, double chol, double gras) throws PlatException {
        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("AuMenu")) {
            return new PlatAuMenu(code, description, prix, recette);
        } else if (type.equalsIgnoreCase("Choisi")) {
            return new PlatChoisi(new PlatAuMenu(code, description, prix, recette), 1);
        } else if (type.equalsIgnoreCase("Enfant")) {
            return new PlatEnfant(code, description, prix, proportion, recette);
        } else if (type.equalsIgnoreCase("Sante")) {
            return new PlatSante(code, description, prix, kcal, chol, gras, recette);
        }

        return null;
    }
}
