package usp.questao1;

public class AdicaoVetorial implements OperacaoVetorial {

    @Override
    public void executarOperacao(Vetores vets) {
        Vetor soma = new Vetor(vets.getV().v1 + vets.getU().v1,vets.getV().v2 + vets.getU().v2, vets.getV().v3 + vets.getU().v3);
        System.out.println("v + u = " + soma);
    }
    
}
