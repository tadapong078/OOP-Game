
package game_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Allgame extends JPanel  {
     private ImageIcon bg_gameplay = new ImageIcon(this.getClass().getResource("bg_gameplay.png"));
            
     Pikachu pika = new Pikachu();
     
     public ArrayList<Bullet> bullet = new ArrayList<Bullet>();
     public ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    
     ImageIcon feildover = new ImageIcon(this.getClass().getResource("background_gover.gif"));
     private JLabel scorebord = new JLabel();
     public int score = 0;
     
     boolean timestart = true;
     boolean startball = false;
     boolean run = true; 
     public int times;
    
     Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });
      
     Thread tballs1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 100) + 1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    zombies.add(new Zombie());
                }
            }
        }
    });
      

     
    Allgame(){
      this.setFocusable(true);
      this.setLayout(null);
      this.add(scorebord);

        
   
      
      this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
               super.keyPressed(e);
               int a = e.getKeyCode();
                if(a==KeyEvent.VK_UP )
                   pika.y-=30;
                    repaint();
                if(a==KeyEvent.VK_DOWN){
                    pika.y+=30;   
                    repaint();   
                }
                if(a==KeyEvent.VK_ENTER){
                     score=0;
                     pika.y = 125;
                     zombies.clear();
                     run=true;
                } if (pika.count > 3) {
                        pika.count = 0;
                    }
                else if (a == KeyEvent.VK_SPACE) {
                    bullet.add(new Bullet(90,pika.y + 30));
                }
            }    
        });
       pika.y = 125;
       actor.start();
       tballs1.start();
     }
     public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bg_gameplay.getImage(),0,-20 ,950,500,this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 28));
            g.drawString("SCORE   " + score, 400, 40);
            
            g.drawImage(pika.pikachu.getImage(),pika.x,pika.y,pika.h,pika.w,this);
            
            for (int i = 0; i < bullet.size(); i++) {
                Bullet bullet2 = bullet.get(i);
                g.drawImage(bullet2.imfire[bullet2.count % 5].getImage(), bullet2.x, bullet2.y, 50, 50, null);
                bullet2.move(); 
                if (bullet2.x  < 0) {
                    bullet.remove(i);
                }
            }
            
            for (int i = 0; i < zombies.size(); i++) {
                g.drawImage(zombies.get(i).getImage(), zombies.get(i).getX(), zombies.get(i).getY(), 60, 62, this);
            }
            for (int i = 0; i < bullet.size(); i++) {
                for (int j = 0; j < zombies.size(); j++) {
                    if (Intersect(bullet.get(i).getbound(), zombies.get(j).getbound())) {
                        zombies.remove(j);
                        bullet.remove(i);
                        score += 10;
                        g.drawString("+10", pika.x + 100, 650);
                    }
                }
            }
            
           
           for (int j = 0; j < zombies.size(); j++) {
            if (Intersect(pika.getbound(), zombies.get(j).getbound())) {
                this.setLayout(null);
                run=false;   
                }
            }            
             if(run==false){
            
              g.drawImage(feildover.getImage(), 0, 0, 1000, 800, this);
              g.setColor(Color.WHITE);
              g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 40));
              g.drawString("SCORE   " + score, 340, 200);
              g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 70));
              g.drawString("GAME OVER", 220, 150);
              g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 27));
              g.drawString("PRESS ENTER TO RESTART", 265, 300);
             }
                
     }
     public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }  
}
     

