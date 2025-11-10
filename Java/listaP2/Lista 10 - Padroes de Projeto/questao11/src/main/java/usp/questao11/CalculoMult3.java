package usp.questao11;

public class CalculoMult3 extends Calculo {
    
    public CalculoMult3(Calculo proximo){
        super(proximo);
    }
    
    @Override
    public double processarQuadrado(double n){
        if(n%3==0) {
            System.out.println("Calculo realizado pelo nucleo 2");
            return n*n;
        }
        else if(proximo != null) return proximo.processarQuadrado(n);
        else{
            System.out.println("Erro");
            return -1;
        }
    }
}
