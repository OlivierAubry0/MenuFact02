package menufact.singleton;

import menufact.exceptions.MenuException;
import menufact.factory.plats.*;

import java.util.ArrayList;

public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plats = new ArrayList<PlatAuMenu>();

    private Menu(String description) {
        this.description = description;
    }

   public void ajoute (PlatAuMenu p)
    {
        plats.add(p);
    }

    public void position(int i)
    {
        courant = i;
    }

    public static Menu menu;
    public static Menu getMenu(String description) {
        return menu = (menu == null) ? new Menu(description) : menu;
    }
    public PlatAuMenu platCourant()
    {
        return plats.get(courant);
    }

    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plats.size())
            throw new MenuException("On depasse le nombre maximal de plats.");
        else
            courant++;
    }

    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimal de plats");
        else
            courant--;
    }

    public int getPosition() {
        return courant;
    }
    public String getDescription() { return description; }
    public PlatAuMenu getPlatAuMenu(int code){
        for(PlatAuMenu plat : plats){
            if(plat.getCode() == code){
                return plat;
            }
        }
        FactoryPlatAuMenu factory = new FactoryPlatAuMenu();
        PlatAuMenu plat = factory.createPlat();
        plat.setDescription("Le plat n'est pas au menu");
        return plat;
    }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plats +
                '}';
    }
}
