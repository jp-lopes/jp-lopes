package usp.questao12;

public class ProcessaMsgTamanho implements Observador {

    @Override
    public void processar(String mensagem) {
        System.out.println("Mensagem processada: " + mensagem + mensagem.length());
    }
    
}
