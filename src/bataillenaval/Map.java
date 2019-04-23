package bataillenaval;

import java.util.Vector;

public class Map {
    int listes;
    int colonnes;
    public int bateauRestant=5;
    Vector grille;

    public Map(int listes, int colonnes) {
        this.listes=listes;
        this.colonnes=colonnes;
        grille= new Vector ();
    }
    
    public void ajouterBateau(Bateau b)
    {
        if(!grille.contains(b))
            grille.add(b);
    }
    
    public void enleverBateau(Bateau b)
    {
        if(grille.contains(b))
            grille.remove(b);
    }
    
    public int coup(Element e)
    {
        String etat;
        for (int i=0; i< grille.size() ; i++) 
            {
                Bateau b = (Bateau) grille.get(i);
                
                etat=b.etat(e);
                if ("touche".equals(etat))
                {
                    System.out.println("\nCRASH!!! un "+b.nom+ " est touché\n"); 
                    return (1);
                }
                else if ("coule".equals(etat))
                {
                    System.out.println("\nBOOM!!! un "+b.nom+" est coulé\n");
                    this.bateauRestant--;
                    enleverBateau(b);
                    return (2);
                }
            } 
        System.out.println("\nSPLASH!!! coup dans l'eau\n");
        return (0);
    }
}
