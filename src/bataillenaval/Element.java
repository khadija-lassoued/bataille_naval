package bataillenaval;

public class Element {
    
    public int abscisse , ordonnee ;
    boolean estTouche ; 
    
// Création d'un élément à partir d'un abscisse et une ordonnée donnes
    public Element ( int abscisse , int ordonnee )
    {
        this.abscisse = abscisse ;
        this.ordonnee = ordonnee ;
        this.estTouche = false ;
    }
    
    @Override
    public String toString ()
    {
        if (this.estTouche)
            return ( "abscisse" + this.abscisse + "  ordonne" + this.ordonnee + "  touche"  );
        else 
            return ( "abscisse" + this.abscisse + "  ordonne" + this.ordonnee + "  intact"  );
    }
    
    void affiche ()
    {
        System.out.println(this);
    }
    
    @Override
    public boolean equals (Object o)
    {
        return (this.abscisse == ((Element)o).abscisse ) && (this.ordonnee == ((Element)o).ordonnee ); 
    }
    
    void testTouche (Element e)
	{
            this.estTouche = this.equals(e);
        }
}
