package modelo;

import auxiliar.Consts;
import auxiliar.Consts.PlayerConsts;
import static auxiliar.Consts.PlayerConsts.ANDANDO;
import static auxiliar.Consts.PlayerConsts.ATACANDO;
import static auxiliar.Consts.PlayerConsts.CORRENDO;
import static auxiliar.Consts.PlayerConsts.IDLE;
import static auxiliar.Consts.PlayerConsts.MORRENDO;
import static auxiliar.Consts.PlayerConsts.PULANDO;
import static auxiliar.LoadSave.importarImagem;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Personagem {
    //Controle das acoes exclusivas do player
    private boolean correndo = false;
    private final float incrementoVelocidadeCorrida = 0.25f * Consts.ESCALA;
    
    public Player(Posicao posicaoInicial, int altura, int largura){
        super(posicaoInicial,altura,largura);
        carregarAnimacoes();
        velocidadeBase = 0.75f * Consts.ESCALA;
        xHitboxOffset = 34 * Consts.ESCALA;
        yHitboxOffset = 28 * Consts.ESCALA;
        inicializarHitbox(posicaoInicial.getX(),posicaoInicial.getY(),25*Consts.ESCALA,32*Consts.ESCALA);
        acaoAtual = Consts.PlayerConsts.IDLE;
        vida = 100;
    }
    
    @Override
    protected final void carregarAnimacoes(){
        animacoes = new BufferedImage[6][];
        BufferedImage sprites;
        //Carrega animacao idle
        sprites = importarImagem("knight/IDLE.png");
        animacoes[0] = new BufferedImage[getQtdSprites(PlayerConsts.IDLE)];
        for(int i=0;i<animacoes[0].length;i++){
            animacoes[0][i] = sprites.getSubimage(i*Consts.LARGURA_SPRITE_PLAYER, 0, Consts.LARGURA_SPRITE_PLAYER, Consts.ALTURA_SPRITE_PLAYER);
        }
            //Carrega animacao de andar
        sprites = importarImagem("knight/WALK.png");
        animacoes[1] = new BufferedImage[getQtdSprites(PlayerConsts.ANDANDO)];
        for(int i=0;i<animacoes[1].length;i++){
            animacoes[1][i] = sprites.getSubimage(i*Consts.LARGURA_SPRITE_PLAYER, 0, Consts.LARGURA_SPRITE_PLAYER, Consts.ALTURA_SPRITE_PLAYER);
        }
        //Carrega animacao de correr
        sprites = importarImagem("knight/RUN.png");
        animacoes[2] = new BufferedImage[getQtdSprites(PlayerConsts.CORRENDO)];
        for(int i=0;i<animacoes[2].length;i++){
            animacoes[2][i] = sprites.getSubimage(i*Consts.LARGURA_SPRITE_PLAYER, 0, Consts.LARGURA_SPRITE_PLAYER, Consts.ALTURA_SPRITE_PLAYER);
        }
        //Carrega animacao de pular
        sprites = importarImagem("knight/JUMP.png");
        animacoes[3] = new BufferedImage[getQtdSprites(PlayerConsts.PULANDO)];
        for(int i=0;i<animacoes[3].length;i++){
            animacoes[3][i] = sprites.getSubimage(i*Consts.LARGURA_SPRITE_PLAYER, 0, Consts.LARGURA_SPRITE_PLAYER, Consts.ALTURA_SPRITE_PLAYER);
        }
        //Carrega animacao de atacar
        sprites = importarImagem("knight/ATTACK.png");
        animacoes[4] = new BufferedImage[getQtdSprites(PlayerConsts.ATACANDO)];
        for(int i=0;i<animacoes[4].length;i++){
            animacoes[4][i] = sprites.getSubimage(i*Consts.LARGURA_SPRITE_PLAYER, 0, Consts.LARGURA_SPRITE_PLAYER, Consts.ALTURA_SPRITE_PLAYER);
        }
        //Carrega animacao de morrer
        sprites = importarImagem("knight/DEATH.png");
        animacoes[5] = new BufferedImage[getQtdSprites(PlayerConsts.MORRENDO)];
        for(int i=0;i<animacoes[5].length;i++){
            animacoes[5][i] = sprites.getSubimage(i*Consts.LARGURA_SPRITE_PLAYER, 0, Consts.LARGURA_SPRITE_PLAYER, Consts.ALTURA_SPRITE_PLAYER);
        }
    }
    
    
    @Override
    public void desenharPersonagem(Graphics g){
        BufferedImage imagem = animacoes[acaoAtual][animation_index];
        int larguraImagem = (int)(Consts.ESCALA*Consts.LARGURA_SPRITE_PLAYER);
        int alturaImagem = (int)(Consts.ESCALA*Consts.ALTURA_SPRITE_PLAYER);
        int posXImagem = (int)(hitbox.x - xHitboxOffset);
        int posYImagem = (int)(hitbox.y - yHitboxOffset);
        
        if(animation_index<getQtdSprites(acaoAtual)){
            g.drawImage(imagem, posXImagem ,posYImagem, larguraImagem, alturaImagem, null);
        }
        //desenharHitbox(g);
    }
    
    @Override
    protected void atualizarPosicao(){
        float posicaoAnteriorX = hitbox.x;
        
        movendo = false;
        
        if(pulando) pular();
               
        float vx=0;
        
        if(dir.isEsquerda()) {
            vx -= velocidadeBase;
            if(correndo) vx-=incrementoVelocidadeCorrida;
        }
        if(dir.isDireita()) {
            vx += velocidadeBase;
            if(correndo) vx+=incrementoVelocidadeCorrida;
        }
        
        if(vx==0 && !noAr) return;

        atualizarPosY();
        atualizarPosX(vx);
        
        if(hitbox.x == posicaoAnteriorX) return;
        
        movendo = true;
    }

    @Override
    protected void atualizarAcaoAtual(){
        
        int acaoInicial = acaoAtual;
        
        if(movendo) {
            if(correndo) acaoAtual = PlayerConsts.CORRENDO;
            else acaoAtual = PlayerConsts.ANDANDO;
        }
        else acaoAtual = PlayerConsts.IDLE;
        
        if(noAr || pulando) acaoAtual = PlayerConsts.PULANDO;

        if(atacando) acaoAtual = PlayerConsts.ATACANDO;
        
        //Se a acao mudar, resetamos a animacao
        if(acaoInicial != acaoAtual) {
            animation_tick = 0;
            animation_index = 0;
        }
    }
    
    @Override
    public int getQtdSprites(int id_acao){
            if(id_acao == IDLE) return 7;
            if(id_acao == ANDANDO) return 8;
            if(id_acao == CORRENDO) return 8;
            if(id_acao == PULANDO) return 1;
            if(id_acao == ATACANDO) return 6;
            if(id_acao == MORRENDO) return 12;
            return -1;
        }
    
    public BufferedImage[][] getAnimacoes(){
        return animacoes;
    }
 
    public int getAcaoAtual(){
        return acaoAtual;
    }

    public boolean isCorrendo() {
        return correndo;
    }

    public void setMovendo(boolean movendo) {
        this.movendo = movendo;
    }

    public void setCorrendo(boolean correndo) {
        this.correndo = correndo;
    }

    public void setAtacando(boolean atacando) {
        this.atacando = atacando;
    }

    public void setPulando(boolean pulando) {
        this.pulando = pulando;
    }
    
}
