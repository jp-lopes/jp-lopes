package Niveis;

public class Nivel {
    private int[][] infoNivel;
    
    public Nivel(int[][] infoNivel){
        this.infoNivel = infoNivel;
    }
    
    public int getIndiceSprite(int x, int y){
        return infoNivel[y][x];
    }
    
    public int[][] getInfoNivel(){
        return infoNivel;
    }
}
