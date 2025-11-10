package usp.questao8;

import java.util.ArrayList;

public class MeusVetores {
    public int[] c1;
    public int[] c2;

    public MeusVetores(int[] c1, int[] c2) {
        this.c1 = c1;
        this.c2 = c2;
    }
    
    public ArrayList<Integer> operarConjutos(OperacaoEntreConjuntos op){
        return op.operar(this);
    }
    
}
