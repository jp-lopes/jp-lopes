package usp.questao4;

public class CalculadoraFacade {
    public double calcular(String operacao, double a, double b){
        return OperacaoFactory.criar(operacao).calcular(a, b);
    }
    
    public double calcularExpressao(String expressao){
        String[] elementos = expressao.trim().split(" ");
        return OperacaoFactory.criar(elementos[1]).calcular(Double.parseDouble(elementos[0]),Double.parseDouble(elementos[2]));
    }
}
