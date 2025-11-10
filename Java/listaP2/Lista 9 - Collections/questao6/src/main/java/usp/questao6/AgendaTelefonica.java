package usp.questao6;

import java.util.TreeMap;

public class AgendaTelefonica {
    TreeMap<String,Long> agenda;
    
    public AgendaTelefonica(){
        agenda = new TreeMap<>();
    }
    
    public void adicionarContato(String nome, long telefone){
        agenda.put(nome,telefone);
    }
    
    public long buscarTelefone(String nome){
        return agenda.get(nome);
    }
    
    public void listarContatos(){
        System.out.println("Agenda Telefonica:");
        for(String nome : agenda.keySet()){
            System.out.println("-> " + nome + " - " + agenda.get(nome));
        }
        System.out.println();
    }
}
