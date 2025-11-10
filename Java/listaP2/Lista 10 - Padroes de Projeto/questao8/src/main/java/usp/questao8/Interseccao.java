package usp.questao8;

import java.util.ArrayList;
import java.util.Comparator;

public class Interseccao implements OperacaoEntreConjuntos {

    @Override
    public ArrayList<Integer> operar(MeusVetores mv) {
        ArrayList<Integer> interseccao = new ArrayList<>();
        for(int i : mv.c1){
            for(int j : mv.c2){
                if(i==j && !interseccao.contains(i)) interseccao.add(i);
            }
        }
        interseccao.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer i, Integer j){
                return Integer.compare(i, j);
            }
        });
        return interseccao;
    }
    
}
