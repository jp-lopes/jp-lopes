package auxiliar;

import gamestates.Gamestate;
import static gamestates.Gamestate.MENU;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.PainelJogo;

public class InputsMouse implements MouseListener, MouseMotionListener{
    private PainelJogo painel;
    
    public InputsMouse(PainelJogo painel){
        this.painel = painel;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        switch(Gamestate.state){
            case MENU:
                painel.getJogo().getMenu().mouseClicked(e);
                break;
            case PLAYING:
                painel.getJogo().getPlaying().mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Nenhum uso
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Nenhum uso
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Nenhum uso
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Nenhum uso
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //Nenhum uso
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //painel.setRectPos(e.getX(),e.getY());
    }
    
    
    
}
