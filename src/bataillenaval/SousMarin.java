
package bataillenaval;

public class SousMarin extends Bateau {
    
    private boolean plonge=false;
    
    public SousMarin(Element origine, boolean plonge ) {
        super(origine,true,1,"sous marin");
        this.plonge = plonge ;
    }
    
    public String etat (Element e)
    {
        //if (this.plonge)
        //    return("intact");
        return(super.etat(e)) ;
    }

    @Override
    public String toString()
    {
        if (this.plonge)
            return (super.toString()+"plongé");
        else
            return (super.toString()+" en surface");
    }
}
