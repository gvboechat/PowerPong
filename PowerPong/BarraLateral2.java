package PowerPong;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarraLateral2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarraLateral2 extends Actor
{
    /**
     * Act - do whatever the BarraLateral2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    public  BarraLateral2(){
        GreenfootImage img = new GreenfootImage(700, 6);
        img.setColor(Color.WHITE);
        img.fillRect(0, 0,img.getWidth()-1, img.getHeight()-1);
        setImage(img);

    }
}
