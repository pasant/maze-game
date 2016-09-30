package maze;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Wall 
{
    
   private ImageIcon img;  
   private String name;
  
  public Wall(ImageIcon img,String name)
  {
     this.name=name; 
     this.img=img;
     
  }
   public Image getimage ()
    {
       return img.getImage();
    }
}
