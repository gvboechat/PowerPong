package PowerPong;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   

    public  Score(){
        GreenfootImage img = new GreenfootImage("Score.png");
        //img.fillRect(0, 0,img.getWidth()-1, img.getHeight()-1);
        setImage(img);    
    }
}
