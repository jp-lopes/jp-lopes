package usp.questao4;

public class Questao4 {
    public static void main(String[] args) {
        CalculadoraFacade calc = new CalculadoraFacade();
        System.out.println(calc.calcular("/", 3, 0));
        System.out.println(calc.calcularExpressao("0.234 + 0.432"));
    }
}
