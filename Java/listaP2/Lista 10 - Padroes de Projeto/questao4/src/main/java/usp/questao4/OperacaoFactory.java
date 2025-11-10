package usp.questao4;

public class OperacaoFactory {
    public static Operacao criar(String tipo){
        switch(tipo){
            case "+":
                return new Soma();
            case "-":
                return new Subtracao();
            case "*":
                return new Multiplicacao();
            case "/":
                return new Divisao();
            default:
                return null;
        }
    }
}
