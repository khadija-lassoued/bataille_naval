package ihm;

import static bataillenaval.Constante.*;
import bataillenaval.Element;
import bataillenaval.Joueur;
import bataillenaval.Map;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Case extends JPanel implements MouseListener{
    
    private String etat;
    PlayerPanel monPanel;
    public Image wave = new ImageIcon("ressources/wave.gif").getImage();
    public Image coup = new ImageIcon("ressources/coup.gif").getImage();
    public Image touche = new ImageIcon("ressources/touche.gif").getImage();
    public Image coule = new ImageIcon("ressources/coule.gif").getImage();
    
    Case(PlayerPanel joueur)
    {
        super();
        this.monPanel=joueur;
        this.addMouseListener(this);   
    }

    public void etat(int x,int y) 
    {
        {
            if (y<= LIGNEMAX && x<= COLLONNEMAX)
            {
                Element e= new Element(x,y);
                int attaque = monPanel.owner.getGrille().coup(e);
                if (attaque==1)
                    etat="touche";
                if (attaque==2)
                    etat="coule";  
            }
        }
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.setColor(Color.BLACK);
        g.drawImage(wave,1,1,getWidth(),getHeight(),this);
        g.drawRect(1,1,getWidth(), getHeight());
        g.fillRect(1, 1, WIDTH, WIDTH);
        
        if (etat=="coup")
            g.drawImage(coup,1,1,getWidth(),getHeight(),this);
        if(etat=="touche")
            g.drawImage(touche,1,1,getWidth(),getHeight(),this);
        if(etat=="coule")  
        {
            g.drawImage(touche,1,1,getWidth(),getHeight(),this);
            monPanel.bateauRestant();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        {
            if(me.getComponent()==this)
            {
                if (monPanel instanceof OrdinateurPanel)
                {
                    etat="coup";
                    this.etat(me.getComponent().getX()/this.getWidth()+1,me.getComponent().getY()/this.getHeight()+1);
                    System.out.print(me.getComponent().getX()/this.getWidth()+1);
                    System.out.print(" ");
                    System.out.println(me.getComponent().getY()/this.getHeight()+1);
                    this.repaint();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
}

