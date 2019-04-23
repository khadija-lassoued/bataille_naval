package bataillenaval;

import static bataillenaval.Constante.COLLONNEMAX;
import static bataillenaval.Constante.LIGNEMAX;

public class Ordinateur extends Joueur {

    public Ordinateur () {
        super("ordinateur");
    }

    @Override
    public Element choisirCoordonnees() {
        int ordonnee = (int) (Math.random() * LIGNEMAX  + 1);
        int abscisse =  (int) (Math.random() * COLLONNEMAX + 1);
        return (new Element(abscisse,ordonnee));
    }
}
