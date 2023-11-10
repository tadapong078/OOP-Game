package game_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Homepage extends JPanel
{
    private ImageIcon background = new ImageIcon(this.getClass().getResource("background.gif"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("start.png"));
    private ImageIcon logo = new ImageIcon(this.getClass().getResource("logo.png"));
    public JButton BStart = new JButton(start);
    Homepage(){
            setLayout(null);
            BStart.setBounds(330,300,170,90);
            add(BStart);
	}
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(background.getImage(),0,-130,900,600,this);
            g.drawImage(logo.getImage(),65,20,750,180,this);	
	}
}
