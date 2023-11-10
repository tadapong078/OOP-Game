
package game_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Playstate extends JFrame implements ActionListener{
    Homepage homepage = new Homepage();
    Allgame all = new Allgame();
    Gameover gv = new Gameover();
    Playstate(){
    this.setSize(1000, 800);
   
    homepage.BStart.addActionListener(this);
    this.add(homepage);
    
    //this.add(all);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homepage.BStart) {
            this.setLocationRelativeTo(null);
            this.setSize(950,500);
            this.remove(homepage);
            this.add(all); 
            all.requestFocusInWindow();
            all.timestart = false;          
        repaint();
        }  
    }

}
