package PowerPong;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class go here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class go extends Actor
{
    public int proximoPasso = 1;
    public static final int Taxa_de_Atualizacao = 50;
    /**
     * Act - do whatever the go wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        saiGo();
    } 
    public void saiGo()
    {
        setImage(new GreenfootImage("numeros/num_"+proximoPasso+".png"));
        Jogo mundo = (Jogo) getWorld();        
        if(mundo.cicloAtual() % Taxa_de_Atualizacao == 0){
            proximoPasso++;
        }

        /*if(proximoPasso == 1){
            Greenfoot.playSound("ContadorGo");
        }*/
        if(proximoPasso == 1){
            ligaSomGo();
        }
        if(proximoPasso > 5){
            mundo.iniciarSomGo = false;
            desligaSomGo();
            ligaSom();
        }
        
        if(proximoPasso > 5){
            proximoPasso = 5;
        }
        
    }
    
    public void ligaSomGo(){
        Jogo World = (Jogo) getWorld();
        World.IniciaSomGo();
    }
     public void ligaSom()
    {
        Jogo World =(Jogo) getWorld();
        World.IniciaSom();
        }
        
    public void desligaSomGo()
    {
        Jogo World =(Jogo) getWorld();
        World.desligaSomGo();
        }
}
