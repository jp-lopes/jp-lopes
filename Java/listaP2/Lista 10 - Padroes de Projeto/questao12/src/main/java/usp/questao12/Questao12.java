package usp.questao12;

public class Questao12 {
    public static void main(String[] args) {
        Chat c = new Chat();
        c.adicionarObservador(new ProcessaMsgMaiuscula());
        c.adicionarObservador(new ProcessaMsgAno());
        c.adicionarObservador(new ProcessaMsgTamanho());

        c.enviarMensagem("Ola");
    }
}
