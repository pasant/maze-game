package maze;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Bomb 
{
    private ImageIcon img;
    private String name;
  
  public Bomb(ImageIcon img,String name)
  {
     this.name=name; 
     this.img=img;
     
  }
   public Image getimage ()
    {
       return img.getImage();
    }
}
