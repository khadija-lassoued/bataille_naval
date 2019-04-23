package ihm;

import bataillenaval.Joueur;
import bataillenaval.Map;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class PlayerPanel extends JPanel{
    Joueur owner;
    Map monMap;
    Grille maGrille;
    JLabel nom;
    JLabel avatar;
    JPanel hp;
    JPanel info;
    PlayerInfo playerInfo;
      
    PlayerPanel(GridBagLayout gl)
    {
        super(gl); 
    }
    
    public void initialiser()
    {
        owner.placerBateaux();
        monMap=owner.getGrille();
        maGrille = new Grille(this);
    }
    
    abstract void setAvatar();
    
    void setHp(int bateauRestant)
    {
        hp= new JPanel(); 
        hp.setLayout(new FlowLayout());
        for (int i=0;i<bateauRestant;i++)
            hp.add(new JLabel(new ImageIcon("ressources/bateau.gif")));
    }
    
    void bateauRestant()
    {
        hp.removeAll();
        hp.updateUI();
        for (int i=0;i<monMap.bateauRestant;i++)
            hp.add(new JLabel(new ImageIcon("ressources/bateau.gif")));
    }
    
    void playerInfo(String nom)
    {
        info = new JPanel();
        info.setLayout(new GridBagLayout());
        GridBagConstraints gbs = new GridBagConstraints();
        gbs.gridx=0;
        gbs.gridy=0;
        
        setAvatar();
        gbs.gridheight = 3;
        gbs.gridwidth = 1;
        gbs.weightx = 1;
        gbs.weighty = 1;
        gbs.anchor = GridBagConstraints.NORTHWEST;
        gbs.insets= new Insets(10,10,0,0);

        info.add(avatar,gbs);
        
        this.nom = new JLabel(nom);
        gbs.anchor = GridBagConstraints.BASELINE_LEADING;
        gbs.insets= new Insets(10,avatar.getIcon().getIconWidth(),0,0);
        
        info.add(this.nom,gbs);
        
        setHp(5);
        gbs.anchor = GridBagConstraints.BASELINE_LEADING;
        gbs.insets= new Insets(0,avatar.getIcon().getIconWidth()+20,0,0);
        
        info.add(hp, gbs);
    }
}
