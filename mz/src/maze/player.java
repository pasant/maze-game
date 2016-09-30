package maze;

import java.awt.*;
import javax.swing.*;

public class player 
{
    private static player uniqueInstance = null ;
    public int tilex, tiley;
    public Image player;
    public String direction;
    public String path = "D:\\mz\\front.png";
    
    public static player getInstance() 
    {
    if (uniqueInstance == null)
        uniqueInstance = new player();
    return uniqueInstance;
    }
    
    public player() 
    {
        tilex = 1;
        tiley = 1;
        ImageIcon img = new ImageIcon(path);
        player = img.getImage();
    }

    public Image getplayer() {
        return player;
    }

    public int gettilex() {
        return tilex;
    }

    public int gettiley() {
        return tiley;
    }
   public void settiles()
    {
        tilex=1;
        tiley=1;
    }
    
    public void move(int dx, int dy)
    {
        tilex += dx;
        tiley += dy;
    }
    public void direction(String direction) 
    {
        this.direction = direction;
    }

    public void path(String direction) {
        if (direction == "up") 
        {
            path = "D:\\mz\\back.png";
            ImageIcon img = new ImageIcon(path);
            player = img.getImage();
        } 
        else if (direction == "down") 
        {
            path = "D:\\mz\\front.png";
            ImageIcon img = new ImageIcon(path);
            player = img.getImage();

        } 
        else if (direction == "right") 
        {
            path = "D:\\mz\\right.png";
            ImageIcon img = new ImageIcon(path);
            player = img.getImage();

        } 
        else if (direction == "left") 
        {
            path = "D:\\mz\\left.png";
            ImageIcon img = new ImageIcon(path);
            player = img.getImage();
        }
    }
}
