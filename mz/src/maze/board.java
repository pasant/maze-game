package maze;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class board extends JPanel implements ActionListener 
{
    int sec;
    int tx=0,ty=0,w=0;
     long start = System.currentTimeMillis();
    int score=0;
    public String tile[][]=new String [60][60];
    private Timer timer;
    private map m;
    private String message="";
    private player p;
    KeyEvent k;
    public Wallfactory factory;
    public Giftfactory factory1;
    public Bombfactory factory2;
    
    public board(Wallfactory factory , Bombfactory factory2 , Giftfactory factory1) 
    {
        this.factory = factory;
        this.factory1 = factory1;
        this.factory2 = factory2;
        
        m = new map();
        p = new player();

        addKeyListener(new Al());
        setFocusable(true);
        requestFocusInWindow();
        timer = new Timer(1000, this);
        timer.start();
    }
    public Wall orderwall(String name)
    {
        Wall wall;
        wall=factory.createwall(name);
        return wall;
    }

    public Bomb orderbomb(String name)
    {
        Bomb bomb;
        bomb=factory2.createbomb(name);
        return bomb;
    }
     
    public Gift ordergift(String name)
    {
        Gift gift;
        gift = factory1.creategift(name);
         return gift;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        
       if (m.getmap(p.gettilex(), p.gettiley()).equals("e")) 
        {
            message = "Winner";
            
        }
       long time = System.currentTimeMillis() - start;
       sec = (int) (time / 1000);
       if((sec%10)==0)
       {
           score--;
       }
        repaint();
    }
    
    public void paint(Graphics g) 
    {
        super.paint(g);
        

        for (int x = 0; x < 30; x++) 
        {
            for (int y = 0; y < 30; y++) 
            {
  
                if(y==28)
               {
                  g.drawImage(orderwall("s").getimage(),y*20, x*20 , this); 
               }
                
                if (m.getmap(x , y).equals("g")) 
                {
                   g.drawImage(m.getgrass(),  y*20, x*20, this);
                }
                
                else if(m.getmap( x,y).equals("t"))
               {
                   g.drawImage(orderwall("t").getimage(),  y*20, x*20 , this);
                
               }
                
                else if(m.getmap( x,y).equals("s"))
               {
                   g.drawImage(orderwall("s").getimage(),  y*20, x*20 , this);
                   
               }
                
                else if (m.getmap(x, y).equals("e")) 
                {
                    g.drawImage(m.getend(), y*20, x*20, this);
                    
                }
                
                else if(m.getmap( x,y).equals("b"))
               {
                    g.drawImage(orderbomb("b").getimage(), y*20, x*20 , this);
                    
               }
                
                else if(m.getmap( x,y).equals("B"))
               {
                   g.drawImage(orderbomb("B").getimage(),  y*20, x*20 , this);
                   
               }
                
                else if(m.getmap( x,y).equals("d"))
               {
                   g.drawImage(ordergift("d").getimage(),  y*20, x*20 , this);
                   
               }
                else if(m.getmap( x,y).equals("D"))
               {
                   g.drawImage(ordergift("D").getimage(),  y*20, x*20 , this);
                 
               } 
            } 
        }
       
        String s= " score "+Integer.toString(score);
        String s1= "time"+Integer.toString(sec);

        Font font =new Font("serif",Font.BOLD,20);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString(s,10+2,50+2);
        g.setColor(Color.red);
        g.drawString(s,10,50);
        Font font1 =new Font("serif",Font.BOLD,20);
        g.setFont(font1);
        g.setColor(Color.black);
        g.drawString(s1,10+2,20+2);
        g.setColor(Color.red);
        g.drawString(s1,10,20);
        g.drawString(message, 20 , 20);
        g.drawImage(p.getplayer() , p.gettilex()*20, p.gettiley()*20 , this);
        repaint();
    }

    public class Al extends KeyAdapter 
    {
        @Override

        public void keyPressed(KeyEvent k) 
        {
            //Gift gift;
            
            System.out.println("p");
            int keycode = k.getKeyCode();
            if (keycode == KeyEvent.VK_UP) 
            {
                p.direction("up");
                 if(m.getmap(p.gettiley()-1,p.gettilex()).equals("g")||m.getmap(p.gettiley()-1,p.gettilex()).equals("e"))
                {
                    p.path("up");
                    p.move(0, -1);
                }
                 else if(m.getmap(p.gettiley()-1,p.gettilex()).equals("b") || m.getmap(p.gettiley()-1,p.gettilex()).equals("B"))
                {
                    m.buildmap();
                    p.settiles();
                  
                }
                  
                else if(m.getmap(p.gettiley()-1,p.gettilex()).equals("d") )
                {
                    m.setgrass(p.gettiley()-1,p.gettilex());
                    repaint();
                    score+=5;
                }
                else if(m.getmap(p.gettiley()-1,p.gettilex()).equals("D"))
                {
                     m.setgrass(p.gettiley()-1,p.gettilex());
                    repaint();
                    score+=10;
                }
            
            }
           else if (keycode == KeyEvent.VK_DOWN) 
            {
                p.direction("down");
                
              
                
                 if(m.getmap(p.gettiley()+1,p.gettilex()).equals("g")||m.getmap(p.gettiley()+1,p.gettilex()).equals("e"))
                {
                    p.path("down");
                    p.move(0, 1);
                }
                
                else if(m.getmap(p.gettiley()+1,p.gettilex()).equals("b") || m.getmap(p.gettiley()+1,p.gettilex()).equals("B"))
                {
                    m.buildmap();
                    p.settiles();
                }
                
                else if(m.getmap(p.gettiley()+1,p.gettilex()).equals("d") )
                {
                    m.setgrass(p.gettiley()+1,p.gettilex());
                    repaint();
                      score+=5;
                }
                 else if(m.getmap(p.gettiley()+1,p.gettilex()).equals("D") )
                {
                    m.setgrass(p.gettiley()+1,p.gettilex());
                    repaint();
                      score+=10;
                }
                 
                
            }
            
           else if (keycode == KeyEvent.VK_RIGHT) 
            {
                p.direction("right");
               if (m.getmap(p.gettiley(),p.gettilex()+1).equals("g")||m.getmap(p.gettiley(),p.gettilex()+1).equals("e"))
                {
                    p.path("right");
                    p.move(1, 0);
                }
                
                else if(m.getmap(p.gettiley(),p.gettilex()+1).equals("b") || m.getmap(p.gettiley(),p.gettilex()+1).equals("B"))
                {
                    m.buildmap();
                    p.settiles();
                }
                
                else if(m.getmap(p.gettiley(),p.gettilex()+1).equals("d") )
                {
                    m.setgrass(p.gettiley(),p.gettilex()+1);
                    repaint();
                      score+=5;
                }
                 else if( m.getmap(p.gettiley(),p.gettilex()+1).equals("D"))
                {
                    m.setgrass(p.gettiley(),p.gettilex()+1);
                    repaint();
                      score+=10;
                }
            }
            
         else   if (keycode == KeyEvent.VK_LEFT) 
            {
                p.direction("left");
                 if (m.getmap(p.gettiley(),p.gettilex()-1).equals("g")||m.getmap(p.gettiley(),p.gettilex()-1).equals("e"))
                {
                    p.path("left");
                    p.move(-1, 0);
                }
                
                else if(m.getmap(p.gettiley(),p.gettilex()-1).equals("b") || m.getmap(p.gettiley(),p.gettilex()-1).equals("B"))
                {
                    m.buildmap();
                    p.settiles();   
                }
                
                else if(m.getmap(p.gettiley(),p.gettilex()-1).equals("d") )
                {
                    m.setgrass(p.gettiley(),p.gettilex()-1);
                    repaint();
                    score+=5;
                      
                }
                else if( m.getmap(p.gettiley(),p.gettilex()-1).equals("D"))
                {
                    m.setgrass(p.gettiley(),p.gettilex()-1);
                    repaint();
                    score+=10; 
                }
            }
         else    if (keycode == KeyEvent.VK_D) 
             {
                  if (!m.getmap(p.gettiley(),p.gettilex()+1).equals("d")&&!m.getmap(p.gettiley(),p.gettilex()+1).equals("D"))
                {
                     m.setgrass(p.gettiley(),p.gettilex()+1);
                     repaint();
                }
             }
       else   if (keycode == KeyEvent.VK_S) 
             {
                  if(!m.getmap(p.gettiley()+1,p.gettilex()).equals("d")&& ! m.getmap(p.gettiley()+1,p.gettilex()).equals("D")&&! m.getmap(p.gettiley()+1,p.gettilex()).equals("e"))
                {
                    m.setgrass(p.gettiley()+1,p.gettilex());
                    repaint();
                }
             }
            else if (keycode == KeyEvent.VK_W) 
             {
                  if(!m.getmap(p.gettiley()-1,p.gettilex()).equals("d")&& ! m.getmap(p.gettiley()-1,p.gettilex()).equals("D")&&! m.getmap(p.gettiley()-1,p.gettilex()).equals("e"))
                {
                    m.setgrass(p.gettiley()-1,p.gettilex());
                    repaint();
                }
             }
           else  if (keycode == KeyEvent.VK_A) 
             {
                
                  if(!m.getmap(p.gettiley(),p.gettilex()-1).equals("d") &&! m.getmap(p.gettiley(),p.gettilex()-1).equals("D")&&! m.getmap(p.gettiley(),p.gettilex()-1).equals("e"))
                {
                    m.setgrass(p.gettiley(),p.gettilex()-1);
                    repaint();
                }
             }
            
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

    }
}
     
//}
