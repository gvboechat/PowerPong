import java.util.*;
import greenfoot.*;

public class Ranking extends World
{
    GreenfootSound sound = new GreenfootSound("SomRanking.wav");
    Nome nomeJogadores =  new Nome();
    /**
     * Constructor for objects of class Ranking.
     */
    public Ranking()
    {
        super(700, 390, 1);
        prepare();
    }
   
    public void act(){
        ligaSom();
        showText(nomeJogadores.getNome1(), 170, 133);
        showText(nomeJogadores.getNome2(), 170, 160);
        showText(""+nomeJogadores.getPlacar1(), 525, 133);
        showText(""+nomeJogadores.getPlacar2(), 525, 160);
    }
  
    private void prepare()
    {
        VoltarInicioRanking voltarinicioranking = new VoltarInicioRanking();
        addObject(voltarinicioranking,355,331);
        ImagemRanking imagemranking = new ImagemRanking();
        addObject(imagemranking,366,47);
        JogadorPontuacaoRanking jogadorpontuacaoranking = new JogadorPontuacaoRanking();
        addObject(jogadorpontuacaoranking,366,117);
        jogadorpontuacaoranking.setLocation(354,108);
    }
    
    public void ligaSom(){
       sound.play();
    }
    
    public void desligaSom(){
       sound.stop();
    }

}
