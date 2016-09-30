package maze;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Gift 
{
    private ImageIcon img;  
    private map m;
    private String name;
    public Image gift;
  
  public Gift(ImageIcon img,String name)
  {
     this.name=name; 
     this.img=img;
  }
   
  public Image getimage ()
    {
       return img.getImage();
    }

   public void drawgrass (String grass)
        {
            if (grass=="g")
            {
                ImageIcon img = new ImageIcon(m.getgrass());
                gift = img.getImage();
            }
        }
}
