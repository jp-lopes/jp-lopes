package usp.questao1;

public class Produtor extends Thread {
    private Deposito deposito;
    private String nome;
    
    public Produtor(String nome, Deposito deposito){
        this.nome = nome;
        this.deposito = deposito;
    }
    
    @Override
    public void run(){
        deposito.put(nome, "Arroz");
        deposito.put(nome, "Feijao");
        deposito.put(nome, "Batata");
        deposito.put(nome, "Trigo");
        deposito.put(nome, "Soja");
        deposito.put(nome, "Centeio");
        deposito.put(nome, "Beterraba");
        deposito.put(nome, "Cenoura");
        deposito.put(nome, "Milho");
        deposito.put(nome, "Alface");
        deposito.put(nome, "Rucula");
        deposito.put(nome, "Abobora");
    }
}
