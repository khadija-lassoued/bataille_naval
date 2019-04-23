package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class PlayerInfo extends Frame implements ActionListener {
    TextField txt;
    Panel nom,gender;
    Button ok;
    JRadioButton homme,femme;
    Application app;
    String sex="f";

    PlayerInfo(Application app)
    {
        super();
        super.setLocationRelativeTo(null);
        nom= new Panel();
        txt = new TextField();
        ok = new Button("ok");
        gender = new Panel();
        setLayout(new BorderLayout()); 
        
        nom.setLayout(new GridLayout(1,2));
        nom.add(new Label("player name : "));
        nom.add(txt);
        
        ButtonGroup group = new ButtonGroup();
        homme= new JRadioButton("man");
        femme = new JRadioButton("women");
        gender.setLayout(new FlowLayout());
        group.add(homme);
        group.add(femme);
        gender.add(homme);
        gender.add(femme);
        gender.add(ok);
        
        add(nom,BorderLayout.CENTER);
        add(gender,BorderLayout.SOUTH);
        
        homme.addActionListener(this);
        femme.addActionListener(this);
        ok.addActionListener(this);
        
        pack();
        setVisible(true);
        
        this.app=app;
    }
    
    String getNamePlayer()
    {
        return(txt.getText());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Game g;
        if (homme.isSelected())
            sex ="h";
        else if (femme.isSelected())
            sex = "f";
        else 
            sex = "o";
        if (ae.getSource()==ok)
        {
            g= new Game(this.getNamePlayer(), sex);
            this.dispose();
            app.dispose();
        }
    }
    
    
}
