package usp.questao1;

public class Consumidor extends Thread {
    private Deposito deposito;
    private String nome;
    private String mercadoria;
    private int mercadoriasConsumidas;
    
    public Consumidor(String nome, Deposito deposito){
        this.nome = nome;
        this.deposito = deposito;
        mercadoriasConsumidas = 0;
    }
    
    @Override
    public void run(){
        mercadoria = deposito.get(nome);
        mercadoriasConsumidas++;
        mercadoria = deposito.get(nome);
        mercadoriasConsumidas++;
        mercadoria = deposito.get(nome);
        mercadoriasConsumidas++;
        mercadoria = deposito.get(nome);
        mercadoriasConsumidas++;
    }
    
    public int getQtdMercadoriasConsumidas(){
        return mercadoriasConsumidas;
    }

    public String getNome() {
        return nome;
    }
    
    
}
