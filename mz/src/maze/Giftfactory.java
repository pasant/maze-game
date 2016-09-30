package maze;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Giftfactory 
{
    public Gift creategift(String name)
    {
        if(name.equals("d"))
        {
            return new gift1(new ImageIcon("D:\\mz\\small.png"),"d");
        }
        else//(name.equals("D"))
        {
            return new gift2(new ImageIcon("D:\\mz\\big.png"),"D");
        }
    }
   
}
