package maze;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wallfactory 
{
    public Wall  createwall(String name)
    {
        if(name.equals("s"))
        {
        return new stonewall(new ImageIcon("D:\\mz\\stoone.png"), "s");
        }
        else//(name.equals("t"))
        {
        return new treewall(new ImageIcon("D:\\mz\\tree.png"), "t");
        }
    }
    
}
