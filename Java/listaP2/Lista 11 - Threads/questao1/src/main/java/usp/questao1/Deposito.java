package usp.questao1;

import java.util.Stack;

public class Deposito {
   private Stack<String> conteudo;
   private int qtdItens;
   
   public Deposito(){
       conteudo = new Stack<>();
       qtdItens = 0;
   }
   
   public synchronized void put(String who, String what){
       if(qtdItens>10){
           try{
               wait(); //Espera ate o deposito ter espaco
           } catch (InterruptedException e){
               System.out.println("Erro:" + e.getMessage());
           }
       }
       conteudo.push(what);
       qtdItens++;
       System.out.println("Produtor " + who + " colocou " + what + " no deposito.\n");
       notifyAll(); //avisa que o deposito foi alterado
   }
    
   public synchronized String get(String who){
       if(qtdItens<=0){
           try{
               wait(); //Espera ate o deposito ter alguma coisa
           } catch (InterruptedException e){
               System.out.println("Erro:" + e.getMessage());
           }
       }
       qtdItens--;
       System.out.println("Consumidor " + who + " retirou " + conteudo.peek() + " do deposito.\n");
       notifyAll(); //avisa que o deposito foi alterado
       return conteudo.pop();
   }
}
