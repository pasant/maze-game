package maze;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class map 
{
   
    private Image wall,grass,end;
    public String map[][]=new String [30][30];
    public map()
    {
      ImageIcon img= new ImageIcon("D:\\mz\\grass.png");
      grass=img.getImage();
      img= new ImageIcon("D:\\mz\\end.png");
      end=img.getImage();
     // openFile();  
     // readFile();
     buildmap();
    } 
    
    public Image getgrass ()
    {
       return grass;
    }
    
    public Image getwall ()
    {
       return wall ;
    }
    
    public Image getend ()
    {
       return end ;
    }
    
    public String getmap (int x,int y)
    {
       String index = map[x][y];
       return index;
    }
   
    public void setgrass (int x,int y)
    {
       map[x][y]="g";
       getgrass();
    }
    
    public void buildmap() 
    {
        int i, j, entr, ext;
        Random ran = new Random();
        ext = ran.nextInt(28) + 1;
        for (j=0; j<30; j++)
       {
          map[0][j] ="s";
       }
        
        for (j=0; j<30; j++)
       {
          map[29][j] = "s";
       }
        
        for (i=1; i<29; i++)
       {
          map[i][0] = "s";
       }
        
        for (i=1; i<29; i++)
       {
          map[i][29] = "s";
       }
          
        map[ext][29] = "e";
         for (i=1; i<29; i++) 
        {
            for (j=1; j<29; j++) 
            {
               int r = ran.nextInt(28) + 1;
               if (r<12)
	       map[i][j] ="s";
               else if (r<15)
	       map[i][j] ="t";
               else
	       map[i][j] = "g";
            }
        }
         
         for (i=1; i<29; i++) 
         {
             for (j=1; j<29; j++) 
             {
      int r = ran.nextInt(28) + 1;
       if(r<2)
      {
	map[i][j] = "B";
      }
       else if(r<3)
      {
	map[i][j] = "b";
      }
       
    }
  }  
  
  for (i=1; i<29; i++) 
  {
    for (j=1; j<29; j++) 
    {
      int r = ran.nextInt(28) + 1;
       if(r<2)
      {
	map[i][j] = "d";
      }
       else if(r<4)
      {
	map[i][j] = "D";
      }
       
    }
  }  
        
  map[1][1]="g";
  map[1][2]="g";
  map[2][1]="g";
  map[2][2]="g";
  
         for(int x=0;x<30;x++)
        {
            for(int y=0;y<30;y++)
            {
            // System.out.print(map[x][y]) ;  
            }
           // System.out.println("") ;
        }
    }
}
    
    
