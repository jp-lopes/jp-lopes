package usp.questao1;

public class Vetor {   
    public double v1, v2, v3;
    
    public Vetor(double v1, double v2, double v3) {
        this.v1=v1;
        this.v2=v2;
        this.v3=v3;
    }
    
    public String toString(){
        return "(" + v1 + ", " + v2 + ", " + v3 + ")";
    }
    
}
