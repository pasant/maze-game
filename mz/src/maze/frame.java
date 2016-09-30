
package maze;

import javax.swing.*;

public class frame  {
    Wallfactory f=new Wallfactory();
    Giftfactory f1=new Giftfactory();
    Bombfactory f2=new Bombfactory();
    
    board b =new board(f,f2,f1);
    
    public frame()
    {
        JFrame f =new JFrame();
        f.setTitle("maze runner");
        f.setSize(615,635);
        //f.addKeyListener(new Al());
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.add(b);
        b.requestFocusInWindow();
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
