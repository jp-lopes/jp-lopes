package usp.questao4;

public class Pilha<T> {
    private class No<U>{
        U valor;
        No<U> prox;
    }
    private No<T> topoPilha;
    private int capacidade;
    private int numElementos;
    
    public Pilha(int capacidade){ 
        topoPilha = null; 
        numElementos = 0;
        this.capacidade = capacidade;
    }
    
    public boolean empilhar(T obj){
        if(numElementos < capacidade){
            if(topoPilha == null){ //Pilha vazia
                topoPilha = new No<>();
                topoPilha.valor = obj;
                topoPilha.prox = null;
                numElementos++;
                return true;
            }
            else{
                No<T> novoNo = new No<>();
                novoNo.prox = topoPilha;
                novoNo.valor = obj;
                
                topoPilha = novoNo;
                
                numElementos++;
                return true;
            }
        }
        else return false;
    }
    
    public T desempilha(){
        if(topoPilha == null){
            System.out.println("Erro: Pilha vazia");
            return null;
        }
        No<T> noRemovido = topoPilha;
        T valorRemovido = noRemovido.valor;
                
        topoPilha = topoPilha.prox;
        numElementos--;
        
        noRemovido = null;
        return valorRemovido;
    }
    
    public void printPilha(){
        No<T> aux = topoPilha;
        System.out.println("### Topo da pilha ###");
        while(aux != null){
            System.out.println("-> " + aux.valor);
            aux = aux.prox;
        }
        System.out.println("### Fim da pilha ###");
    }
    
    
}
