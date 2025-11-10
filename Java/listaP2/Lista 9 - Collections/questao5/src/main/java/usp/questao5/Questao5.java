package usp.questao5;

import java.util.HashSet;

public class Questao5 {
    public static void main(String[] args) {
        String[] alunos = {"Joao", "Maria", "Jose", "Pedro", "Carlos", "Ana", "Cristina"};

        HashSet<String> matriculadosPOO = new HashSet<>();
        HashSet<String> matriculadosBD = new HashSet<>();
        
        //Joao, Pedro e Ana fazem POO
        matriculadosPOO.add("Joao");
        matriculadosPOO.add("Pedro");
        matriculadosPOO.add("Ana");
        
        //Maria, Pedro e Carlos fazem BD
        matriculadosBD.add("Maria");
        matriculadosBD.add("Pedro");
        matriculadosBD.add("Carlos");
        
        System.out.println("Quais alunos estao matriculados simultaneamente nas duas disciplinas?");
        for(String aluno : alunos){
            if(matriculadosPOO.contains(aluno) && matriculadosBD.contains(aluno)) 
                System.out.println(aluno);
        }
        
        System.out.println("\nQuais alunos estao matriculados somente em uma delas");
        for(String aluno : alunos){
            if( (matriculadosPOO.contains(aluno) && !matriculadosBD.contains(aluno)) 
            || (!matriculadosPOO.contains(aluno) && matriculadosBD.contains(aluno)))
                System.out.println(aluno);
        }
        
        System.out.println("\nQuais alunos estao matriculados em pelo menos uma das disciplinas?");
        for(String aluno : alunos){
            if(matriculadosPOO.contains(aluno) || matriculadosBD.contains(aluno)) 
                System.out.println(aluno);
        }
        
        System.out.println("\nQuais alunos nao estao matriculados em nenhuma das disciplinas?");
        for(String aluno : alunos){
            if(!matriculadosPOO.contains(aluno) && !matriculadosBD.contains(aluno)) 
                System.out.println(aluno);
        }
        
    }
}
