package gamestates;

import auxiliar.Consts;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import main.Jogo;

public class Menu extends State implements StateMethods {

    public Menu(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void atualizar() {
        
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.black);
        g.drawString("MENU", Consts.LARGURA_JANELA/2, 200);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            Gamestate.state = Gamestate.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
