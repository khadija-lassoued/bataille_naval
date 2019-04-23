package ihm;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;

public class Application extends Frame implements WindowListener,ActionListener{
    Button start;
    public Image fond = new ImageIcon("ressources/fond.jpg").getImage();
    
    Application()
    {
        super("Bataille navale");
        start = new Button("start");
        start.setBackground(Color.WHITE);
        JPanel pcenter =new JPanel();
        pcenter.setOpaque(false);
        pcenter.setLayout(new FlowLayout());
        pcenter.add(start);
        add(pcenter, BorderLayout.SOUTH);
        super.setSize(1366,768);
        start.addActionListener(this);
        addWindowListener(this);
        setVisible(true);
    }
    
    void newGame()
    {
        
    }
  
    @Override
    public void paint(Graphics g)
    {
        g.drawImage(fond, 0, 0, getWidth(), getHeight(), null);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        Menu m;
        if(ae.getSource()==start)
            m=new Menu(this);
    }
}
