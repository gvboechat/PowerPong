import greenfoot.*;  
public class BarraCentral extends Actor
{
    
    public void act() 
    {
        
    } 
    
     public  BarraCentral(){
         GreenfootImage img = new GreenfootImage(6, 348);
         img.setColor(Color.WHITE);
         img.fillRect(0, 0,img.getWidth()-1, img.getHeight()-1);
         setImage(img);
    
    }
}
