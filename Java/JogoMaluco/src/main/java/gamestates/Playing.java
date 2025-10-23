package gamestates;

import Niveis.GerenciadorNivel;
import auxiliar.Consts;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import main.Jogo;
import modelo.Player;
import modelo.Slime;

public class Playing extends State implements StateMethods {
    private Player player;
    private Slime slime;
    private GerenciadorNivel gerenciadorNivel;
    private final Posicao posicaoInicialPlayer = new Posicao(2*Consts.TAMANHO_BLOCOS,Consts.ALTURA_JANELA-7*Consts.TAMANHO_BLOCOS);
    private final Posicao posicaoInicialSlime = new Posicao(Consts.LARGURA_JANELA - 3*Consts.TAMANHO_BLOCOS,Consts.ALTURA_JANELA-7*Consts.TAMANHO_BLOCOS);

    public Playing(Jogo jogo) {
        super(jogo);
        inicializarClasses();
    }

    private void inicializarClasses(){
        gerenciadorNivel = new GerenciadorNivel(jogo);
        player = new Player(posicaoInicialPlayer,(int)(Consts.ESCALA*Consts.ALTURA_SPRITE_PLAYER),(int)(Consts.ESCALA*Consts.LARGURA_SPRITE_PLAYER)); 
        player.carregarInfoNivel(gerenciadorNivel.getNivelAtual().getInfoNivel());
        slime = new Slime(posicaoInicialSlime,(int)(Consts.ESCALA*Slime.ALTURA_SPRITE_SLIME),(int)(Consts.ESCALA*Slime.LARGURA_SPRITE_SLIME), player);
        slime.carregarInfoNivel(gerenciadorNivel.getNivelAtual().getInfoNivel());
    }
    
    public void windowFocusLost(){
        player.getDir().resetDir();
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void atualizar() {
        gerenciadorNivel.atualizarNivel();
        player.atualizarPersonagem();
        slime.atualizarPersonagem();
    }

    @Override
    public void desenhar(Graphics g) {
        gerenciadorNivel.desenharNivel(g);
        slime.desenharPersonagem(g);
        player.desenharPersonagem(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Ataque
        if(e.getButton() == MouseEvent.BUTTON1){
            player.setAtacando(true);
        }
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
        switch(e.getKeyCode()){
            //Resetar nivel
            case KeyEvent.VK_R:
                player.resetarPosicao();
                slime.resetarPosicao();
                break;
            //Movimentos
            case KeyEvent.VK_W:
                player.getDir().setCima(true);
                break;
            
            case KeyEvent.VK_S:
                player.getDir().setBaixo(true);
                break;
                
            case KeyEvent.VK_A:
                player.getDir().setEsquerda(true);
                break;
            
            case KeyEvent.VK_D:
                player.getDir().setDireita(true);
                break;
            //Corrida 
            case KeyEvent.VK_SHIFT:
                player.setCorrendo(true);
                break;
            //Pulo
            case KeyEvent.VK_SPACE:
                player.setPulando(true);
                break;  
            //Alterna para o menu
            case KeyEvent.VK_ESCAPE:
                Gamestate.state = Gamestate.MENU;
                break;    
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                player.getDir().setCima(false);
                break;
            
            case KeyEvent.VK_S:
                player.getDir().setBaixo(false);
                break;
                
            case KeyEvent.VK_A:
                player.getDir().setEsquerda(false);
                break;
            
            case KeyEvent.VK_D:
                player.getDir().setDireita(false);
                break;
                
            case KeyEvent.VK_SHIFT:
                player.setCorrendo(false);
                break;

            case KeyEvent.VK_SPACE:
                player.setPulando(false);
                break;    
        }
    }
    
}
