package usp.questao3;

public class Chamado {
    private String descricao;
    private String prioridade;

    public Chamado(String descricao, String prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }
    
    @Override
    public String toString(){
        return "{" + descricao + " - " + prioridade + "}";
    }
    
    public String getPrioridade(){
        return prioridade;
    }
}
