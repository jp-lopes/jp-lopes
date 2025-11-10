package usp.questao12;

public class ProcessaMsgAno implements Observador {

    @Override
    public void processar(String mensagem) {
        System.out.println("Mensagem processada: " + mensagem + "2025");
    }
    
}
