package ihm;

import static bataillenaval.Constante.COLLONNEMAX;
import static bataillenaval.Constante.LIGNEMAX;
import bataillenaval.Map;
import bataillenaval.Ordinateur;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OrdinateurPanel extends PlayerPanel{
    
    public OrdinateurPanel(GridBagLayout gl,PlayerPanel ennemie) {
        super(gl);
        owner = new Ordinateur();
        playerInfo("ordinateur");
        owner.maGrille=new Map(LIGNEMAX,COLLONNEMAX);
        this.initialiser();
    }

    @Override
    void setAvatar() {
            avatar = new JLabel(new ImageIcon("ressources/ordinateur.png"));
    }
}
