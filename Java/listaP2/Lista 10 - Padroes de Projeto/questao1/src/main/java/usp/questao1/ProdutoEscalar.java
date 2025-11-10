package usp.questao1;

public class ProdutoEscalar implements OperacaoVetorial {

    @Override
    public void executarOperacao(Vetores vets) {
        double produtoEscalar = vets.getV().v1 * vets.getU().v1 + vets.getV().v2 * vets.getU().v2 + vets.getV().v3 * vets.getU().v3;
        System.out.println("v . u = " + produtoEscalar);
    }
    
}
