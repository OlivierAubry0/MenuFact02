package menufact.factory.plats;

import menufact.factory.exceptions.PlatException;

public class PlatFactory {
    public static Plat createPlat(String type, int code, String description, double prix, double proportion, double kcal, double chol, double gras) throws PlatException {
        if (type == null) {
            return null;
        }

        PlatAuMenu platAuMenu = new PlatAuMenu(code, description, prix);

        if (type.equalsIgnoreCase("AuMenu")) {
            return platAuMenu;
        } else if (type.equalsIgnoreCase("Choisi")) {
            return new PlatChoisi(platAuMenu, 1); // Assuming quantity 1, you can change it as needed.
        } else if (type.equalsIgnoreCase("Enfant")) {
            return new PlatEnfant(code, description, prix, proportion);
        } else if (type.equalsIgnoreCase("Sante")) {
            return new PlatSante(code, description, prix, kcal, chol, gras);
        }

        return null;
    }
}
