package auxiliar;

public class Posicao {
    float x,y;

    public Posicao(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public void incrementarX(float valor){
        x += valor;
    }
    
    public void incrementarY(float valor){
        y += valor;
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    

}
