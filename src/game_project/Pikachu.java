
package game_project;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author SSP
 */
public class Pikachu {
   public ImageIcon pikachu = new ImageIcon(this.getClass().getResource("Pikachu.gif"));
    public int y;
    public int x;
    public int h = 110;
    public int w = 83;
    public int count = 0;
    
    
  Pikachu(){
      this.x=x;
      this.y=y;
    }
  public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,60,50));
    }
}