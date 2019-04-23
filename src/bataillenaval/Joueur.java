package bataillenaval;

import static bataillenaval.Constante.*;

public abstract class Joueur {

    private String nom;
    private int nombreCoup=0;
    public Map maGrille;
    protected Map advGrille;
    public Joueur ennemie;

    public Joueur(String nom)
    {
        this.nom = nom;
        this.maGrille = new Map(LIGNEMAX,COLLONNEMAX);
    }
    
    public void initialiser(Joueur ennemie)
    {
        this.ennemie = ennemie;
        advGrille = ennemie.getGrille();
    }
   
    //supposons que c'est toujours aléatoire
    public final void placerBateaux () 
    {
        boolean orientation;
        Element origine;
        
        orientation =choisiroriantation();
        origine= choisirOrigine(3,orientation);
        Bateau b1 = new Croiseur (origine,Math.random()<0.5);
        
        orientation =choisiroriantation();
        origine= choisirOrigine(3,orientation);
        Bateau b2 = new Croiseur (origine,Math.random()<0.5);
        
        orientation =choisiroriantation();
        origine= choisirOrigine(2,orientation);
        Bateau b3 = new Escorteur (origine,Math.random()<0.5);
        
        orientation =choisiroriantation();
        origine= choisirOrigine(1,orientation);
        Bateau b4 = new SousMarin (origine,Math.random()<0.5);

        orientation =choisiroriantation();
        origine= choisirOrigine(1,orientation);
        Bateau b5 = new SousMarin (origine,Math.random()<0.5);
        
        maGrille.ajouterBateau(b1);
        maGrille.ajouterBateau(b2);
        maGrille.ajouterBateau(b3);
        maGrille.ajouterBateau(b4);
        maGrille.ajouterBateau(b5);
    }	
	
    Element lancerAttaque()
    {
        Element e = this.choisirCoordonnees();
        this.nombreCoup++;
        return e;
    }
        
        
    public abstract Element choisirCoordonnees();
	
    public final Element choisirOrigine (int taille,boolean orientation)
    {
        int abscisse = 0,ordonnee = 0;
        
        if (orientation)
        {
            ordonnee =  (int) (Math.random() * LIGNEMAX + 1); 
            do
            {
               abscisse = (int) (Math.random() * COLLONNEMAX + 1);
            }while( (abscisse + taille - 1 ) >= COLLONNEMAX );
        }
        else
        {
            abscisse =  (int) (Math.random() * COLLONNEMAX + 1); 
            do
            {
               ordonnee = (int) (Math.random() * LIGNEMAX  + 1);
            }while( (ordonnee + taille - 1 ) >= LIGNEMAX );
        }

        return (new Element(abscisse,ordonnee));
    }
    
    private boolean choisiroriantation() {
        return(Math.random()<0.5);
    }    
	
    public Map getGrille()
    {
        return this.maGrille;
    }
	
    public String getNom()
    {
        return this.nom;
    }
    
    public void setNom(String nom)
    {
        this.nom= nom;
    }
	
    public int getNbreCoup()
    {
        return this.nombreCoup;
    }
    
    public Map getMapEnnemie()
    {
        return this.ennemie.getGrille();
    }
}

