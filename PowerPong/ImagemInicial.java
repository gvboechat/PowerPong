package PowerPong;

import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class ImagemInicial extends Actor
{
    private Integer imagem = 1;
    /**
     * Act - do whatever the ImagemInicial wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        mudaImagem();
    }
    
    public void atualizaImagem(){
        float resultado = 0;
        resultado = getWorldOfType(Inicio.class).getCiclo()%10;
        if(resultado==0){
            imagem = imagem +1;
        }
    }
    
    public void mudaImagem(){
        if(imagem >=1){
            if(imagem<=5){
                setImage("Imagens/img_0" + imagem + ".png");
                atualizaImagem();
            }
        }
        if(imagem > 5){
            imagem = 1;
        }
    }
}
