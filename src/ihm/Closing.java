package ihm;

import java.awt.*;
import java.awt.event.*;

public class Closing extends Frame implements WindowListener,ActionListener{
    Button yes;
    Button cancel;
    Label text ;
    Panel pNorth,pSouth;
    
    
    Closing()
    {
        super.setLocationRelativeTo(null);
        text = new Label("are you sure ?");
        yes=new Button("yes");
        cancel=new Button("cancel");
        pSouth = new Panel();
        pNorth = new Panel();
        pNorth.add(text);
        pSouth.setLayout(new FlowLayout());
        pSouth.add(yes);
        pSouth.add(cancel);
        setLayout(new BorderLayout());
        add(this.pNorth,BorderLayout.NORTH);
        add(this.pSouth,BorderLayout.SOUTH);
        yes.addActionListener(this);
        cancel.addActionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent we){}

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
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
        if (ae.getSource()==cancel)
            super.dispose();
        else 
            System.exit(0);
    }
    
    
}
