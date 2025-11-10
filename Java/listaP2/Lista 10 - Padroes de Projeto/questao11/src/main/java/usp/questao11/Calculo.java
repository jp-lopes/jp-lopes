package usp.questao11;

public abstract class Calculo {
    protected Calculo proximo;
    
    public Calculo(Calculo proximo){
        this.proximo = proximo;
    }
    
    public abstract double processarQuadrado(double n);
}
