package usp.questao8;

import java.util.ArrayList;

public class Questao8 {

    public static void main(String[] args) {
        int[] c1 = {1,3,5,7,9,10};
        int[] c2 = {2,4,6,8,9,10};
        ArrayList<Integer> resultado;
        
        MeusVetores mv = new MeusVetores(c1,c2);
        
        resultado = mv.operarConjutos(OperacaoFactory.criar("interseccao"));
        System.out.print("interseccao: ");
        for(Integer i : resultado){
            System.out.print(i + " ");
        }
        System.out.println();
        
        resultado = mv.operarConjutos(OperacaoFactory.criar("uniao"));
        System.out.print("uniao: ");
        for(Integer i : resultado){
            System.out.print(i + " ");
        }
        System.out.println();
        
        resultado = mv.operarConjutos(OperacaoFactory.criar("diferenca"));
        System.out.print("diferenca: ");
        for(Integer i : resultado){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
