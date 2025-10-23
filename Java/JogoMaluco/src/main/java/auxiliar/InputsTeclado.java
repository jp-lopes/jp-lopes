package auxiliar;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.PainelJogo;
import auxiliar.Consts.Direcoes;
import gamestates.Gamestate;
import static gamestates.Gamestate.MENU;
import static gamestates.Gamestate.PLAYING;

public class InputsTeclado implements KeyListener {
    private final PainelJogo painel;
    
    public InputsTeclado(PainelJogo painel){
        this.painel = painel;
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        //Nenhum uso
    }
 
    @Override
    public void keyReleased(KeyEvent e){
        switch(Gamestate.state){
            case MENU:
                painel.getJogo().getMenu().keyReleased(e);
                break;
            case PLAYING:
                painel.getJogo().getPlaying().keyReleased(e);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        switch(Gamestate.state){
            case MENU:
                painel.getJogo().getMenu().keyPressed(e);
                break;
            case PLAYING:
                painel.getJogo().getPlaying().keyPressed(e);
        }
    }
    
}
