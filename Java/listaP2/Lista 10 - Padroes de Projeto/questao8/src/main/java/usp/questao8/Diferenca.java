package usp.questao8;

import java.util.ArrayList;
import java.util.Comparator;

public class Diferenca implements OperacaoEntreConjuntos {

    @Override
    public ArrayList<Integer> operar(MeusVetores mv) {
        ArrayList<Integer> diferenca = new ArrayList<>();

        for(int i : mv.c1) diferenca.add(i);
        
        for(int i : mv.c2){
            if(diferenca.contains(i)) diferenca.remove((Integer)i);
        }
        diferenca.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer i, Integer j){
                return Integer.compare(i, j);
            }
        });
        return diferenca;
    }
    
}
