package usp.questao2;

public class Questao2 {
    
    public static void verificarExpressao(String expressao){
        Pilha pilha = new Pilha();
        boolean erro = false;
        for(int i=0;i<expressao.length();i++){
            if(expressao.charAt(i) == '(') pilha.push(expressao.charAt(i));
            else if (expressao.charAt(i) == ')') {
                erro = (pilha.pop() == null);
                if(erro) break;
            }
        }
        if(pilha.isEmpty() && !erro) System.out.println("Expressao Balanceada!");
        else System.out.println("Expressao Desbalanceada...");
    }
    
    public static void main(String[] args) {
        String expressao1 = "((1-32)/3)";
        String expressao2 = "(1/(12-3)";
        String expressao3 = "(4*10)))";
        String expressao4 = "((134+32)*(4))";
        
        verificarExpressao(expressao1);
        
        verificarExpressao(expressao2);
        
        verificarExpressao(expressao3);
        
        verificarExpressao(expressao4);
        
    }
}
