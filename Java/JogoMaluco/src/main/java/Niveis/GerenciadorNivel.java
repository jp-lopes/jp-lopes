package Niveis;

import auxiliar.Consts;
import static auxiliar.LoadSave.carregarInfoNivel;
import static auxiliar.LoadSave.importarImagem;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Jogo;

public class GerenciadorNivel {
    private Jogo jogo;
    private BufferedImage[] sprites;
    private Nivel nivelUm;

    public GerenciadorNivel(Jogo jogo) {
        this.jogo = jogo;
        carregarSprites();
        nivelUm = new Nivel(carregarInfoNivel());
    }
    
    private void carregarSprites(){
        sprites = new BufferedImage[85];
        BufferedImage imagem = importarImagem("terreno/level1.png");
        for(int j=0;j<4;j++){
            for(int i=0;i<12;i++){
                int indice = j*12 + i;
                sprites[indice] = imagem.getSubimage(i*32, j*32, 32, 32);
            }
        }
    }
    
    public void desenharNivel(Graphics g){
        for(int j=0;j<Consts.BLOCOS_NA_ALTURA;j++){
            for(int i=0;i<Consts.BLOCOS_NA_LARGURA;i++){
                int indice = nivelUm.getIndiceSprite(i, j);
                g.drawImage(sprites[indice], i*Consts.TAMANHO_BLOCOS, j*Consts.TAMANHO_BLOCOS, Consts.TAMANHO_BLOCOS, Consts.TAMANHO_BLOCOS, null);
            }
        }
        
    }
    
    public void atualizarNivel(){
        
    }
    
    public Nivel getNivelAtual(){
        return nivelUm;
    }
    
    
    
}
