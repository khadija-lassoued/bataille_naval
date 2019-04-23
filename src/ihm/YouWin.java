package ihm;

import java.awt.Frame;
import java.awt.Label;

public class YouWin extends Frame{
    YouWin()
    {
        super();
        add(new Label("you win"));
        this.pack();
        this.setVisible(true);
    }
}
