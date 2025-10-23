package modelo;

import auxiliar.Consts;
import auxiliar.Direcao;
import auxiliar.Posicao;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class Personagem {
    protected Posicao posicaoInicial;
    protected Direcao dir;
    protected int vida;
    protected BufferedImage[][] animacoes = null;
    //Controle de movimento e acoes
    protected int acaoAtual = 0;
    protected boolean movendo = false, atacando = false, morrendo = false, pulando = false;
    protected float velocidadeBase = 0f; //velocidade de movimento
    protected float velocidadeAr = 0f;
    protected float velocidadePulo = -2.25f * Consts.ESCALA;
    protected float velocidadeQuedaPosColisao = 0.5f * Consts.ESCALA;
    protected boolean noAr = false;
    //Controle de animacoes
    protected int animation_tick = 0;
    protected int animation_index = 0;
    protected int animation_speed = 15; //8 animacoes por segundo e 120 FPS => 15 frames por animacao
    //Colisoes
    protected Rectangle2D.Float hitbox;
    protected float xHitboxOffset;
    protected float yHitboxOffset;
    protected int altura,largura;
    protected final float gravidade = 0.04f * Consts.ESCALA;
    //Tem o nivel para poder detectar colisoes
    protected int[][] infoNivel;

    public Personagem(Posicao posicaoInicial, int altura, int largura){
        this.posicaoInicial = posicaoInicial;
        dir = new Direcao();
        this.altura = altura;
        this.largura = largura;
    }
    
    protected abstract void carregarAnimacoes();
    
    protected abstract void atualizarPosicao();
    
    public abstract void desenharPersonagem(Graphics g);
    
    protected abstract void atualizarAcaoAtual();
        
    public abstract int getQtdSprites(int id_acao);
    
    protected void inicializarHitbox(float x, float y, float largura, float altura){
        hitbox = new Rectangle2D.Float(x,y,largura,altura);
    }
    
    public Rectangle2D.Float getHitbox(){
        return hitbox;
    }
    
    protected void desenharHitbox(Graphics g){
        g.setColor(Color.PINK);
        g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
    }

    protected boolean isPersonagemNoChao(Rectangle2D.Float hitbox, int[][] infoNivel){
        //Checar pixel inferior esquerdo e inferior direito
        if(!isSolido(hitbox.x,hitbox.y+hitbox.height+1,infoNivel)){
            if(!isSolido(hitbox.x+hitbox.width,hitbox.y+hitbox.height+1,infoNivel)){
                return false;
            }
        }
        return true;
    }
    
    public void carregarInfoNivel(int[][] infoNivel){
        this.infoNivel = infoNivel;
        verificarGravidade();
    }

    public void verificarGravidade(){
        if(!isPersonagemNoChao(hitbox, infoNivel)) {
            noAr = true;
        }
    }
    
    protected void atualizarTickAnimacao(){
        animation_tick++;
        if(animation_tick >= animation_speed){
            animation_tick = 0;
            animation_index++;
            if(animation_index >= getQtdSprites(acaoAtual)){
                animation_index = 0;
                atacando = false;
            }
        }
    }
    
    public void atualizarPersonagem(){
        atualizarPosicao();      
        atualizarTickAnimacao();
        atualizarAcaoAtual();
    }

    protected void pular(){
        if(noAr) return;
        noAr = true;
        velocidadeAr = velocidadePulo;
    }
    
    protected void resetarNoAr(){
        noAr = false;
        velocidadeAr = 0;
    }

    protected void atualizarPosX(float vx){
        if(isPosValida(hitbox.x+vx, hitbox.y, hitbox.width, hitbox.height, infoNivel)){
            hitbox.x += vx;
        }
    }
    
    protected void atualizarPosY(){
        if(!noAr && !isPersonagemNoChao(hitbox, infoNivel)) noAr = true;
            
        if(noAr){
            if(isPosValida(hitbox.x, hitbox.y + velocidadeAr, hitbox.width, hitbox.height, infoNivel)){
                hitbox.y += velocidadeAr;
                velocidadeAr += gravidade;
                
            }
            else{
                if(velocidadeAr>0) resetarNoAr();
                else velocidadeAr = velocidadeQuedaPosColisao; 
            }
        }
    }
    
    public boolean isPosValida(float x, float y, float largura, float altura, int[][] infoNivel){
        if(!isSolido(x,y,infoNivel)){
            if(!isSolido(x+largura,y+altura,infoNivel)){
                if(!isSolido(x+largura,y,infoNivel)){
                    if(!isSolido(x,y+altura,infoNivel)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isSolido(float x, float y, int[][] infoNivel){
        if(x<0 || x >= Consts.LARGURA_JANELA) return true;
        if(y<0 || y >= Consts.ALTURA_JANELA) return true;
        
        float xIndice = x/Consts.TAMANHO_BLOCOS;
        float yIndice = y/Consts.TAMANHO_BLOCOS;
        
        int valor = infoNivel[(int)yIndice][(int)xIndice];
        
        if (valor>=48 || valor <0 || valor != 11) return true;
        
        return false;
    }
    
    public void resetarPosicao(){
        hitbox.x = posicaoInicial.getX();
        hitbox.y = posicaoInicial.getY();
        verificarGravidade();
        dir.resetDir();
    }
    
    public Posicao getPosiscaoInicial() {
        return posicaoInicial;
    }

    public Direcao getDir() {
        return dir;
    }
    
    public int getVida(){
        return vida;
    }
    
    public void incrementarVida(int valor){
        this.vida += valor;
    }

    public boolean isMovendo() {
        return movendo;
    }

    public boolean isAtacando() {
        return atacando;
    }

    public boolean isMorrendo() {
        return morrendo;
    }

    public float getVelocidadeBase() {
        return velocidadeBase;
    }
}
