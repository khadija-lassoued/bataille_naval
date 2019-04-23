package bataillenaval;

import java.util.Scanner;


public class Jeu {
    static Humain j1;
    static Ordinateur o;
        
    public static void jouer ()
    {
        Element coup;
        do
        {
            coup=j1.lancerAttaque();
            o.maGrille.coup(coup);
        }while (!o.maGrille.grille.isEmpty());
        
        System.out.println("\nFélicitation ! vous avez coulé tous les bateaux après"+j1.getNbreCoup()+"coups");
    }
  
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        o =new Ordinateur();
        System.out.println("entrer votre nom");
        String nom= sc.nextLine();
        j1 = new Humain(nom);
        j1.initialiser(o);
        o.placerBateaux();
        jouer ();
    }    
}
