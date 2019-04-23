package ihm;

import static bataillenaval.Constante.COLLONNEMAX;
import static bataillenaval.Constante.LIGNEMAX;
import bataillenaval.Humain;
import bataillenaval.Map;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class HumainPanel extends PlayerPanel{
    String gender;
    
    public HumainPanel(GridBagLayout gl, String nom, String gender, PlayerPanel ennemie) {
        super(gl);
        owner = new Humain(nom);
        owner.maGrille=new Map(LIGNEMAX,COLLONNEMAX);
        this.gender = gender;
        playerInfo(nom);
        this.initialiser();
        owner.getGrille().toString();
    }

    @Override
    void setAvatar() {
        if(gender.equalsIgnoreCase("f"))
            avatar = new JLabel(new ImageIcon("ressources/joueurF.png"));
        else 
            avatar = new JLabel(new ImageIcon("ressources/joueurH.png"));
    }
    
    void Winner()
    {
        YouWin msg;
        if(this.owner.ennemie.maGrille.bateauRestant==0)
            msg = new YouWin();
    } 
    
    void Loser()
    {
        YouLose msg;
        if(this.owner.maGrille.bateauRestant==0)
            msg = new YouLose();
    } 
}
