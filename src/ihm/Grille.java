package ihm;

import static bataillenaval.Constante.*;
import bataillenaval.Joueur;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Grille extends Panel implements MouseMotionListener {
    public Image cible = new ImageIcon("ressources/cible.png").getImage();
    
    Grille (PlayerPanel joueur) { 
        setLayout(new GridLayout(LIGNEMAX,COLLONNEMAX));
        for (int i=0; i<LIGNEMAX; i++) 
            for (int j=0; j<COLLONNEMAX; j++) 
                add(new Case(joueur));
        addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent me) {}

    @Override
    public void mouseMoved(MouseEvent me) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Cursor Curseur = tk.createCustomCursor( cible, new Point( 1, 1 ), "Pointeur" );
        setCursor( Curseur );
    }
}
