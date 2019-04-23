package ihm;

import java.awt.*;
import java.awt.event.*;

public class Menu extends Frame implements WindowListener,ActionListener{
    Application app;
    Button newGame;
    Button rules;
    Button exit;
    
    Menu(Application app)
    {
        this.app=app;
        super.setLocationRelativeTo(null);
        newGame=new Button("start new Game");
        rules=new Button("rules");
        exit=new Button("exit");
        setLayout(new GridLayout(3,1));
        add(newGame);
        add(rules);
        add(exit);
        newGame.addActionListener(this);
        rules.addActionListener(this);
        exit.addActionListener(this);
        addWindowListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent we){}

    @Override
    public void windowClosing(WindowEvent we) {
        super.dispose();
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
        PlayerInfo info;
        Rules r;
        if (ae.getSource()==newGame) 
        {
            info= new PlayerInfo(app);
            this.dispose();
        }
        else if (ae.getSource()==rules)
        {
            r = new Rules();
            this.dispose();
        }
        else
            System.exit(0);
    } 
}