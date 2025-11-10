package usp.questao1;

public class Questao1 {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        Produtor p1 = new Produtor("Jose", deposito);
        Consumidor c1 = new Consumidor("Joao", deposito);
        Consumidor c2 = new Consumidor("Pedro", deposito);
        Consumidor c3 = new Consumidor("Carlos", deposito);
        
        p1.start();
        c1.start();
        c2.start();
        c3.start();
        
        try{
            p1.join();
            c1.join();   
            c2.join();
            c3.join();
        } catch (InterruptedException e){
            System.out.println("Erro: " + e.getMessage());
        }
        
        Consumidor[] consumidores = {c1,c2,c3};
        int max = -1;
        for(Consumidor c : consumidores){
            if(c.getQtdMercadoriasConsumidas() > max) max = c.getQtdMercadoriasConsumidas();
        }

        for(Consumidor c : consumidores){
            if(c.getQtdMercadoriasConsumidas() == max) {
                System.out.println("Consumidor que mais consumiu: " + c.getNome());
            }
        }
        
    }
}
