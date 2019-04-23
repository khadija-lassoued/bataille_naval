package bataillenaval;

import static bataillenaval.Constante.COLLONNEMAX;
import static bataillenaval.Constante.LIGNEMAX;
import java.util.Scanner;


public class Humain extends Joueur {
    Scanner sc= new Scanner(System.in);
    
    public Humain(String nom) {
        super(nom);
    }

    @Override
    public Element choisirCoordonnees() 
    {
        int abscisse;
        int ordonnee;
        do
        {
            System.out.println("\nentrer les cordonnées ");
            abscisse = sc.nextInt();
            ordonnee = sc.nextInt();
        } while (abscisse<0 || abscisse>COLLONNEMAX || ordonnee<0 || ordonnee>LIGNEMAX);
                    
        return(new Element (abscisse,ordonnee));
    }
}
