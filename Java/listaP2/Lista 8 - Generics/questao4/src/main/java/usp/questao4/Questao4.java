package usp.questao4;

public class Questao4 {
    public static void main(String[] args) {
        Pilha<Integer> pilhaInt = new Pilha<>(10);
        
        for(int i=1;i<=15;i++){
            if(pilhaInt.empilhar(i))System.out.println("Valor Empilhado: " + i);
            else System.out.println("Nao foi possivel empilhar " + i + " pois a pilha esta cheia.");
        }
            
        pilhaInt.printPilha();
        
        System.out.println("Valor desempilhado: " + pilhaInt.desempilha());
        System.out.println("Valor desempilhado: " + pilhaInt.desempilha());
        
        pilhaInt.printPilha();
    }
}
