package maze;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Bombfactory 
{
    public Bomb  createbomb(String name)
    {
        if(name.equals("b"))
        {
            return new bomb1(new ImageIcon("D:\\mz\\bomb1.jpg"),"b");
        }
        else//(name.equals("B"))
        {
            return new bomb2(new ImageIcon("D:\\mz\\bomb2.png"),"B");
        }
    }
}
