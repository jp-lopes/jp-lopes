package usp.questao1;

public class Vetores {
    private Vetor v, u;
    
    public Vetores(Vetor v, Vetor u){
        this.v = v;
        this.u = u;
    }
    
    public void operarVetores(OperacaoVetorial op){
        op.executarOperacao(this);
    }

    public Vetor getV() {
        return v;
    }

    public Vetor getU() {
        return u;
    }
    
    
    
}
