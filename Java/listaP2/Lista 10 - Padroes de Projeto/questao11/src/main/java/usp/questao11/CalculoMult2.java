package usp.questao11;

public class CalculoMult2 extends Calculo {
    
    public CalculoMult2(Calculo proximo){
        super(proximo);
    }
    
    @Override
    public double processarQuadrado(double n){
        if(n%2 == 0) {
            System.out.println("Calculo realizado pelo nucleo 1");
            return n*n;
        }
        else if(proximo != null) return proximo.processarQuadrado(n);
        else{
            System.out.println("Erro");
            return -1;
        }
    }
}
