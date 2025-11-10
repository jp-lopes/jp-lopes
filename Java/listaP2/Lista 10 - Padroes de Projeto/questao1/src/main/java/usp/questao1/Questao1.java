package usp.questao1;

public class Questao1 {
    public static void main(String[] args) {
        Vetores vets = new Vetores(new Vetor(1,4,5), new Vetor(3,4,9));
        System.out.print("Soma: ");
        vets.operarVetores(new AdicaoVetorial());
        
        System.out.print("Produto Escalar: ");
        vets.operarVetores(new ProdutoEscalar());
    }
}
