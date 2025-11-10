package usp.questao12;

import java.util.ArrayList;

public class Chat implements Observado {
    private ArrayList<Observador> moderadores;
    
    public Chat(){
        moderadores = new ArrayList<>();
    }
    
    public void enviarMensagem(String mensagem){
        System.out.println("Publicando mensagem: " + mensagem);
        notificarObservadores(mensagem);
    }
    
    @Override
    public void adicionarObservador(Observador o) {
        moderadores.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
        moderadores.remove(o);
    }

    @Override
    public void notificarObservadores(String mensagem) {
        for(Observador o : moderadores){
            o.processar(mensagem);
        }
    }
    
}
