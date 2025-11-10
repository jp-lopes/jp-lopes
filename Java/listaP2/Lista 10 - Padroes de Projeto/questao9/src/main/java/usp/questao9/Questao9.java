package usp.questao9;

public class Questao9 {
    public static void main(String[] args) {
        Divida div = new Divida();
        Juros divJ = new Juros(div);
        Desconto des = new Desconto(divJ);
        AcrescimoTaxa at = new AcrescimoTaxa(des);
        
        System.out.println("Descricao: " + at.getDesc());
        System.out.println("Valor: " + at.getValor());
    }
}
