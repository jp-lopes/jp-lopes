package modelo;

import auxiliar.Consts;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static auxiliar.LoadSave.importarImagem;
import auxiliar.Posicao;
import java.awt.geom.Rectangle2D;

public class Slime extends Personagem{
    public static final int ALTURA_SPRITE_SLIME = 32;
    public static final int LARGURA_SPRITE_SLIME = 32;
    public static final int IDLE = 0;
    public static final int ATACANDO = 1;
    public static final int ANDANDO = 2;
    //Tem o player para poder detectar e seguir
    private Player player;
    private Rectangle2D.Float areaVisao;
    private Rectangle2D.Float areaPerseguicao;

    
    public Slime(Posicao posicaoInicial, int altura, int largura, Player player){
        super(posicaoInicial,altura,largura);
        this.player = player;
        carregarAnimacoes();
        velocidadeBase = 0.15f * Consts.ESCALA;
        xHitboxOffset = 3 * Consts.ESCALA;
        yHitboxOffset = 12 * Consts.ESCALA;
        inicializarHitbox(posicaoInicial.getX(),posicaoInicial.getY(),26*Consts.ESCALA,20*Consts.ESCALA);
        vida = 50;
        acaoAtual = IDLE;
        animation_speed = 30;
        areaVisao = new Rectangle2D.Float(hitbox.x-80,hitbox.y,hitbox.width+160,hitbox.height+50);
        areaPerseguicao = new Rectangle2D.Float(hitbox.x-300,hitbox.y,hitbox.width+600,hitbox.height+70);
    }
    
    private void atualizarAreas(){
        areaVisao.x = hitbox.x - 80;
        areaVisao.y = hitbox.y - 50; 
        areaPerseguicao.x = hitbox.x - 300;
        areaPerseguicao.y = hitbox.y - 70;
    }
    
    @Override
    public int getQtdSprites(int id_acao){
        if(id_acao==IDLE) return 4;
        if(id_acao==ATACANDO) return 5;
        if(id_acao==ANDANDO) return 3;
        return -1;
    }
    
    @Override
    protected final void carregarAnimacoes() {
        animacoes = new BufferedImage[3][];
        BufferedImage sprites;
        //Idle
        sprites = importarImagem("slime/Slime_Idle.png");
        animacoes[0] = new BufferedImage[4];
        for(int i=0;i<4;i++){
            animacoes[0][i] = sprites.getSubimage(i*LARGURA_SPRITE_SLIME, 0, LARGURA_SPRITE_SLIME,ALTURA_SPRITE_SLIME);
        }
        //Ataque
        sprites = importarImagem("slime/Slime_Attack_Angry.png");
        animacoes[1] = new BufferedImage[5];
        for(int i=0;i<5;i++){
            animacoes[1][i] = sprites.getSubimage(i*LARGURA_SPRITE_SLIME, 0, LARGURA_SPRITE_SLIME,ALTURA_SPRITE_SLIME);
        }
        //Andar
        sprites = importarImagem("slime/Slime_Walk_Angry.png");
        animacoes[2] = new BufferedImage[3];
        for(int i=0;i<3;i++){
            animacoes[2][i] = sprites.getSubimage(i*LARGURA_SPRITE_SLIME, 0, LARGURA_SPRITE_SLIME,ALTURA_SPRITE_SLIME);
        }
    }

    @Override
    protected void atualizarPosicao() {
        movendo = false;
        atualizarAreas();
        //Verifica se o player esta proximo
        if(areaVisao.intersects(player.hitbox)) {
            if(hitbox.intersects(player.hitbox)){
                player.vida = 0;
                atacando = true;
            }
            //Player a esquerda do slime
            if(player.hitbox.x - hitbox.x < 0) dir.setEsquerda(true);
            //Player a direita do slime
            else dir.setDireita(true);
        }
        if(!areaPerseguicao.intersects(player.hitbox)) dir.resetDir();
        
        if(!dir.isDireita() && !dir.isEsquerda() && !noAr) return;
        
        float vx=0;
        float posicaoAnteriorX = hitbox.x;
        
        if(dir.isDireita()) vx += velocidadeBase;
        if(dir.isEsquerda()) vx -= velocidadeBase;
        
        atualizarPosY();
        atualizarPosX(vx);
        //Se bater numa parede, alterna a direcao
        if(hitbox.x == posicaoAnteriorX){
            dir.setDireita(!dir.isDireita());
            dir.setEsquerda(!dir.isEsquerda());
        }
        movendo = true;
    }

    @Override
    public void desenharPersonagem(Graphics g) {
        if(animation_index<getQtdSprites(acaoAtual)){
            g.drawImage(animacoes[acaoAtual][animation_index], (int)(hitbox.x - xHitboxOffset),(int)(hitbox.y - yHitboxOffset), 
                       (int)(Consts.ESCALA*LARGURA_SPRITE_SLIME), (int)(Consts.ESCALA*ALTURA_SPRITE_SLIME), null);            
        }
        //desenharHitbox(g);
        //g.drawRect((int)areaVisao.x, (int)areaVisao.y, (int)areaVisao.width, (int)areaVisao.height);
        //g.drawRect((int)areaPerseguicao.x, (int)areaPerseguicao.y, (int)areaPerseguicao.width, (int)areaPerseguicao.height);
    }

    @Override
    protected void atualizarAcaoAtual() {
        acaoAtual = IDLE;
        if(movendo) acaoAtual = ANDANDO;
        if(atacando) acaoAtual = ATACANDO;
    }
    
    
    
}