package bataillenaval;

import static bataillenaval.Constante.COLLONNEMAX;
import static bataillenaval.Constante.LIGNEMAX;

public abstract class Bateau {
    
    public Element [] liste ;
    protected boolean horizontal ;
    protected String nom;
    private int elementTouche=0;
    
    Bateau ( Element origine,boolean oriantation,int taille,String nom )
    {
        liste = new Element [taille] ;
        this.nom= nom;
        this.liste[0] = origine ;
        this.horizontal=oriantation;
        this.placer(this.liste[0].abscisse, this.liste[0].ordonnee);
        this.afficher();
    }
    
    @Override
    public String toString ()
    {
        String s=this.nom;
	        for(int i=0;i<liste.length;i++)
	            s+="\n"+liste[i].toString();
	        return s;
    }
    
    public void afficher ()
    {
       System.out.println(this);
    }
               
    public void placer (int abscisse,int ordonnee)
    {
        if( this.horizontal )
            for (int i=0 ; i< this.liste.length ; i++ )
                this.liste [i] = new Element (abscisse+i ,ordonnee ) ;
        else
            for (int i=0 ; i< this.liste.length; i++ )
                this.liste [i] = new Element (abscisse ,ordonnee + i) ;
    }
    
    String etat ( Element e)
    {
        for (int i =0 ; i < this.liste.length ; i++) 
        {
            this.liste[i].testTouche(e);
            if (this.liste[i].equals(e))
            {
                elementTouche++;
                if (elementTouche==liste.length)
                    return("coule");
                return("touche");
            }
        }
        return("intact");
    }
}
