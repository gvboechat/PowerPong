import lang.stride.*;
import greenfoot.*;

public class Bola extends Actor
{
    public int res = 0;//variavel satanica pra fazer o codigo dar certo sem pacto
    public int speed = 3;
    public int hDirection = 1;//Direita:1 Esquerda:-1
    public int vDirection = 1;//Cima:-1 Baixo=1    
    public boolean controle = true;
    public int toquePorUltimo;
    

    public void act()
    {                               
        vaiBola();
        changeDirection();
        chutarBola();
        chutarBola2();
        movimentacomPong();
        movimentacomPong2();
        somaPontoUm();
        somaPontoDois();
        addRes();
        speedUp();
        resetRes();
        pegaModificadorGanharPowerBoost();
        pegaModificadorTamanhoDoPad();
        ToqueNoPong();
    }    

    public void pegaModificadorGanharPowerBoost(){ 
        Actor obj = getOneIntersectingObject(ModificadorGanharPowerBoost.class);
        if (obj != null){
            Greenfoot.playSound("SomGanharPowerBoost.wav");
            getWorldOfType(Jogo.class).removeObject(obj);
            if(toquePorUltimo == 1){
                getWorldOfType(Jogo.class).pong.addTimeBoost();
            }
            else if(toquePorUltimo == 2){
                getWorldOfType(Jogo.class).pong2.addTimeBoost(); 
            }
        }
    }
    
    public void pegaModificadorTamanhoDoPad(){
        Actor obj = getOneIntersectingObject(ModificadorDeTamanhoPad.class);
        if (obj != null){
            Greenfoot.playSound("SomGanharPowerBoost.wav");
            getWorldOfType(Jogo.class).removeObject(obj);
            if(toquePorUltimo == 1){
                getWorldOfType(Jogo.class).pong.ModificarTamanhoPad();
            }
            else if(toquePorUltimo == 2){
                getWorldOfType(Jogo.class).pong2.ModificarTamanhoPad(); 
            }
        }
    }
    
    public void ToqueNoPong(){
        Actor obj = getOneIntersectingObject(Pong.class);
        Actor obj2 = getOneIntersectingObject(Pong2.class);
        if(obj != null){
           toquePorUltimo = 1;
        }else if(obj2 != null){
            toquePorUltimo = 2;
        }
    }

    public void vaiBola(){
        Jogo mundo = (Jogo) getWorld();
        if(mundo.cicloAtual()>193){
            movimentoBola();
        }
    }


    public void movimentoBola(){
        if(controle){
            int newX = getX() + hDirection * speed;
            int newY = getY() + vDirection * speed;
            setLocation(newX,newY);
        }
    }

    public void changeDirection(){
        Pong pong = (Pong)getOneIntersectingObject(Pong.class);
        Pong2 pong2 = (Pong2)getOneIntersectingObject(Pong2.class);         
        if(getX()>=getWorld().getWidth() - 5){
            hDirection*=-1;
        }
        if(getY()>=getWorld().getHeight() - 5){
            vDirection*=-1;
        }
        if(getX() <= 5){
            hDirection*=-1;
        }
        if(getY() <= 5){
            vDirection*=-1;
        }
        if(getY() <= 30 && isTouching(BarraLateral.class)){
            vDirection*=-1;
        }
        if(getY() <= 367 && isTouching(BarraLateral2.class)){
            vDirection*=-1;
        }
        if((getX() <= 60) && pong != null){
            Greenfoot.playSound("ToquePong.wav");
            hDirection*= -1;
        }
        if((getY() <= 650) && pong2 != null){
            Greenfoot.playSound("ToquePong.wav");
            hDirection*= - 1;
        }
    }

    public void somaPontoUm(){
        if(getX()>= 695){
            Greenfoot.playSound("FazGol.wav");
            Jogo World =(Jogo) getWorld();
            World.acrescentaPontosUm(1);
            World.acrescentaPontosPartida(1);
            this.controle = false;
            resetBolaPontoUm();
        }                    
    }

    public void chutarBola(){        
        if(Greenfoot.isKeyDown("space") && isTouching(Pong.class)){
            this.controle = true;
        }
    }

    public void chutarBola2(){        
        if(Greenfoot.isKeyDown("backspace") && isTouching(Pong2.class)){
            this.controle = true;
        }
    }    

    public void resetBolaPontoUm(){
        Pong pong = (Pong)getOneIntersectingObject(Pong.class);
        if(getX()>=695){
            setLocation(63, 198);
        }
    }

    public void resetBolaPontoDois(){
        if(getX()<=5){
            setLocation(647, 198);
        }
    }                    

    public void somaPontoDois(){
        if(getX()<=5){
            Greenfoot.playSound("FazGol.wav");
            Jogo World = (Jogo) getWorld();
            World.acrescentaPontosDois(1);
            World.acrescentaPontosPartida(1);
            this.controle = false;
            resetBolaPontoDois();
        }
    }

    public void addRes(){        
        Jogo mundo = getWorldOfType(Jogo.class);           
        if (mundo.oTempoEstaZerado()){
            Greenfoot.playSound("SomSpeedUp.wav");
            res = res+1;
        }                 
    }

    public void speedUp(){
        if(res == 8){
            speed = speed + 2;
        }
    }

    public void resetRes(){
        if(res == 8){
            res = 0;
        }
    }

    public Bola(){
        GreenfootImage img = new GreenfootImage(18, 17);
        img.setColor(Color.WHITE);
        img.fillRect(0, 0,img.getWidth()-1, img.getHeight()-1);
        setImage(img);
    }

    public void movimentacomPong(){
        if(controle == false && isTouching(Pong.class)){ 
            if(getY()<=321){    
                if(Greenfoot.isKeyDown("S")){
                    this.setLocation(getX(), getY() + 3);
                }
            }
            if(getY()>=63){ 
                if(Greenfoot.isKeyDown("W")){
                    this.setLocation(getX(), getY() - 3);
                }
            }
        }
    }

    public void movimentacomPong2(){
        if(controle == false && isTouching(Pong2.class)){ 
            if(getY()<=321){    
                if(Greenfoot.isKeyDown("down")){
                    this.setLocation(getX(), getY() + 3);
                }
            }
            if(getY()>=63){ 
                if(Greenfoot.isKeyDown("up")){
                    this.setLocation(getX(), getY() - 3);
                }
            }
        }
    }
}