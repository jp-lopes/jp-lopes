package auxiliar;

public class Direcao {
    private boolean esquerda, direita, baixo, cima;
    
    public Direcao(){
        resetDir();
    }
    
    public final void resetDir(){
        esquerda = false;
        direita = false;
        baixo = false;
        cima = false;
    }

    public boolean isEsquerda() {
        return esquerda;
    }

    public void setEsquerda(boolean esquerda) {
        this.esquerda = esquerda;
    }

    public boolean isDireita() {
        return direita;
    }

    public void setDireita(boolean direita) {
        this.direita = direita;
    }

    public boolean isBaixo() {
        return baixo;
    }

    public void setBaixo(boolean baixo) {
        this.baixo = baixo;
    }

    public boolean isCima() {
        return cima;
    }

    public void setCima(boolean cima) {
        this.cima = cima;
    }
    
    
}
