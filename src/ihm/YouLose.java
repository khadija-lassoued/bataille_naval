/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.Frame;
import java.awt.Label;

/**
 *
 * @author Toshiba
 */
public class YouLose extends Frame{
    YouLose()
    {
        super();
        add(new Label("you win"));
        this.pack();
        this.setVisible(true);
    }
    
}
