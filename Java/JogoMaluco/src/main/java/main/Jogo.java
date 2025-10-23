package main;

import Niveis.GerenciadorNivel;
import auxiliar.Consts;
import auxiliar.Posicao;
import gamestates.Gamestate;
import static gamestates.Gamestate.MENU;
import static gamestates.Gamestate.PLAYING;
import gamestates.Menu;
import gamestates.Playing;
import java.awt.Graphics;
import modelo.Player;

public class Jogo implements Runnable{

    private JanelaJogo janela;
    private PainelJogo painel;
    private Thread threadJogo;
    //Frames por segundo do jogo
    public static final int FPS = 120;
    //Updates por segundo do jogo
    public static final int UPS = 200;
    
    private Playing playing;
    private Menu menu;
    
    public Jogo(){
        inicializarClasses();
        //Cria janela e painel
        this.painel = new PainelJogo(this);
        this.janela = new JanelaJogo(painel);
        this.painel.requestFocus();
        //Comeca o loop de jogo
        this.ComecarLoopJogo();
    }
    
    private void inicializarClasses(){
        menu = new Menu(this);
        playing = new Playing(this);
    }
    
    private void ComecarLoopJogo(){
        this.threadJogo = new Thread(this);
        this.threadJogo.start();
    }
    
    public void atualizarJogo(){
        switch(Gamestate.state){
            case MENU:
                menu.atualizar();
                break;
            case PLAYING:
                playing.atualizar();
                break;
            default:
                break;
        }
    }
    
    public void desenharJogo(Graphics g){
        switch(Gamestate.state){
            case MENU:
                menu.desenhar(g);
                break;
            case PLAYING:
                playing.desenhar(g);
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        //Nanossegundos por frame
        double tempoPorFrame = 1000000000.0 / FPS;
        //Nanossegundo por update
        double tempoPorUpdate = 1000000000.0 / UPS;
        
        //Inicializa contadores de tempo
        long ultimoTempo = System.nanoTime();
        long tempoAtual;
        long ultimaChecagem = System.currentTimeMillis();
        
        //Contadores de frame e de updates
        int frames = 0;
        int updates = 0;

        
        double deltaUpdate = 0;
        double deltaFrame = 0;
        
        while(true){
            tempoAtual = System.nanoTime();
            
            deltaUpdate += (tempoAtual - ultimoTempo)/tempoPorUpdate;
            deltaFrame += (tempoAtual - ultimoTempo)/tempoPorFrame;
            ultimoTempo = tempoAtual;
            
            if(deltaUpdate >= 1){  
                atualizarJogo();
                updates++;
                deltaUpdate--;
            }
            
            if(deltaFrame >= 1){
                this.painel.repaint();
                frames++;
                deltaFrame--;
            }
            

            //Contador de FPS e UPS
            if(System.currentTimeMillis() - ultimaChecagem >= 1000) {
                ultimaChecagem = System.currentTimeMillis();
                //System.out.println("FPS: " + frames + "| UPS: " + updates);
                frames = 0;
                updates = 0;
            }
                  
        }
        
    }
    public void windowFocusLost(){
        if(Gamestate.state == Gamestate.PLAYING) playing.getPlayer().getDir().resetDir();
    }

    public Playing getPlaying() {
        return playing;
    }

    public Menu getMenu() {
        return menu;
    }
   
}
