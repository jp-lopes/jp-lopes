package usp.questao4;

public class Divisao implements Operacao{

    @Override
    public double calcular(double a, double b) {
        if(b==0) {
            System.out.println("ERRO: Divisao por zero");
            return -1;
        }
        return a/b;
    }
    
}
