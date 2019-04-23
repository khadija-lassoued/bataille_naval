/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Toshiba
 */
public class Rules extends Frame implements WindowListener{
    Rules()
    {
        super("rules");
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4,1));
        add(new Label("Un jeu de bataille navale se compose d'un tableau et d'un ensemble de bateaux, "));
        add(new Label ("chaque bateau se compose d'un ensemble de taille fixe d'élements. "));
        add(new Label ("Un croiseur comprend 3 éléments, un escorteur 2 et un sous-marin un seul élément. "));
        add(new Label("Chaque élément est caractérisé par sa position et par son état: sain ou touché. Les sous-marins ont la possibilité de plonger. Lorsqu'ils plongent ils ne peuvent pas être touchés."));
        this.pack();
        this.setVisible(true);
        this.addWindowListener(this);
    }
    @Override
    public void windowOpened(WindowEvent we){}

    @Override
    public void windowClosing(WindowEvent we) {
        this.dispose();
    }
    
    @Override
    public void windowClosed(WindowEvent we) {}

    @Override
    public void windowIconified(WindowEvent we) {}

    @Override
    public void windowDeiconified(WindowEvent we) {}

    @Override
    public void windowActivated(WindowEvent we) {}

    @Override
    public void windowDeactivated(WindowEvent we) {}
}
