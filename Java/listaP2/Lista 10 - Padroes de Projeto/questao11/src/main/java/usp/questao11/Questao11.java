package usp.questao11;

public class Questao11 {
    public static void main(String[] args) {
        Calculo c = new CalculoMult2(new CalculoMult3(new CalculoDemais(null)));
        System.out.println(c.processarQuadrado(2));
        System.out.println(c.processarQuadrado(3));
        System.out.println(c.processarQuadrado(7));
        System.out.println(c.processarQuadrado(14));
    }
}
