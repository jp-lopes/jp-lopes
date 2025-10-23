
package main;

import auxiliar.Consts;
import auxiliar.InputsMouse;
import auxiliar.InputsTeclado;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PainelJogo extends JPanel{
    private final Jogo jogo;
    
    public PainelJogo(Jogo jogo) {
        this.jogo = jogo;
        //Configura o tamanho do painel
        this.setTamanhoPainel();
        //Adiciona leitura do teclado e do mouse
        InputsTeclado it = new InputsTeclado(this);
        InputsMouse im = new InputsMouse(this);
        this.addKeyListener(it);
        this.addMouseListener(im);
        this.addMouseMotionListener(im);
    }
    
    private void setTamanhoPainel() {
        Dimension tamanho = new Dimension(Consts.LARGURA_JANELA,Consts.ALTURA_JANELA);
        //System.out.println("Largura: " + Consts.LARGURA_JANELA + "| Altura: " + Consts.ALTURA_JANELA);
        this.setMinimumSize(tamanho);
        this.setPreferredSize(tamanho);
        this.setMaximumSize(tamanho);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        jogo.desenharJogo(g);
    }

    public Jogo getJogo() {
        return jogo;
    }

}

