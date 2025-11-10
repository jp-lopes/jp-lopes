package usp.questao11;

public class CalculoDemais extends Calculo {
   
    public CalculoDemais(Calculo proximo){
        super(proximo);
    }
    
    @Override
    public double processarQuadrado(double n){
        System.out.println("Calculo realizado pelo nucleo 3");
        return n*n;
    }
    
}
