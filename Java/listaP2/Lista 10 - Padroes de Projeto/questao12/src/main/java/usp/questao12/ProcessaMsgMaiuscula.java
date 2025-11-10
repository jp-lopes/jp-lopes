package usp.questao12;

public class ProcessaMsgMaiuscula implements Observador {

    @Override
    public void processar(String mensagem) {
        System.out.println("Mensagem processada: " + mensagem.toUpperCase());
    }
    
}
