package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Toshiba
 */
public class Game extends Frame implements WindowListener{
    PlayerPanel monPanel,advPanel;

    Game(String nom,String gender)
    {
        super("new game");
        this.setSize(1366,768);
        setLayout(new GridLayout(1,2));
        monPanel = new HumainPanel(new GridBagLayout(),nom,gender,advPanel);
        advPanel = new OrdinateurPanel(new GridBagLayout(),monPanel);
        monPanel.owner.initialiser(advPanel.owner);
        advPanel.owner.initialiser(monPanel.owner);
        
        GridBagConstraints gbs = new GridBagConstraints();
        gbs.gridheight = 1;
        gbs.gridwidth = 1;
        gbs.weightx = 1;
        gbs.weighty = 0;
        gbs.fill = GridBagConstraints.BOTH;
        gbs.anchor = GridBagConstraints.NORTHWEST;
                
        monPanel.add(monPanel.info,gbs);
        advPanel.add(advPanel.info,gbs);
        
        gbs.weighty = 0.5;
        gbs.gridy = 2;
        gbs.insets= new Insets(5,5,5,5);
        
        monPanel.add(monPanel.maGrille,gbs);
        advPanel.add(advPanel.maGrille,gbs);
                
        monPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        advPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        add(monPanel);
        add(advPanel);

        addWindowListener(this);
        setVisible(true);
    }
    
    @Override
    public void windowOpened(WindowEvent we){}

    @Override
    public void windowClosing(WindowEvent we) {
        Closing c =new Closing();
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
