package auxiliar;

import java.io.File;

public class Consts {
    public static final float ESCALA = 1.5f; //multiplicador de tamanho dos sprites - ALTERAR APENAS ISSO PARA AUMENTAR OU DIMINUIR A TELA!
    //Formato dos sprites do player
    public static final int LARGURA_SPRITE_PLAYER = 96;
    public static final int ALTURA_SPRITE_PLAYER = 84;
    //Formato da janela do jogo
    public static final int TAMANHO_PADRAO_BLOCOS = 32; //Blocos de 32x32 pixels
    
    public static final int BLOCOS_NA_LARGURA = 26;
    public static final int BLOCOS_NA_ALTURA = 14;
    public final static int TAMANHO_BLOCOS = (int)(TAMANHO_PADRAO_BLOCOS * ESCALA);
    public static final int LARGURA_JANELA = BLOCOS_NA_LARGURA * TAMANHO_BLOCOS;
    public static final int ALTURA_JANELA = BLOCOS_NA_ALTURA * TAMANHO_BLOCOS;
    //Path para as imagens   
    public static final String PATH = File.separator+"imgs"+File.separator;
    
    //Constantes de controle das animacoes do personagem
    public static class PlayerConsts{
        //Define um id para cada acao do jogador
        public static final int IDLE = 0;
        public static final int ANDANDO = 1;
        public static final int CORRENDO = 2;
        public static final int PULANDO = 3;
        public static final int ATACANDO = 4;
        public static final int MORRENDO = 5;
    }
    
    //Constantes de controle de direcoes
    public static class Direcoes{
        //Define um id para cada direcao
        public static final int ESQUERDA = 0;
        public static final int CIMA = 1;
        public static final int DIREITA = 2;
        public static final int BAIXO = 3;
    }
    
}
