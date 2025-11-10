package usp.questao12;

public interface Observado {
    public void adicionarObservador(Observador o);
    
    public void removerObservador(Observador o);
    
    public void notificarObservadores(String mensagem);
}
