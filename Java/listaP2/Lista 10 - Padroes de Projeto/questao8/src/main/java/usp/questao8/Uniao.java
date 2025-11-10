package usp.questao8;

import java.util.ArrayList;
import java.util.Comparator;

public class Uniao implements OperacaoEntreConjuntos{

    @Override
    public ArrayList<Integer> operar(MeusVetores mv) {
        ArrayList<Integer> uniao = new ArrayList<>();
        for(int i : mv.c1){
            uniao.addLast(i);
        }
        for(int i : mv.c2){
            if(!uniao.contains(i)) uniao.addLast(i);
        }
        uniao.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer i, Integer j){
                return Integer.compare(i, j);
            }
        });
        return uniao;
    }
    
    
}
