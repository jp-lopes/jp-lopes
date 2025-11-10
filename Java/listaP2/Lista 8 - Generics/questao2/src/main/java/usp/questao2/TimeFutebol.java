package usp.questao2;

public class TimeFutebol implements Comparable<TimeFutebol> {
    private String nome;
    private int qtdPontos;

    public TimeFutebol(String nome, int qtdPontos){
        this.nome = nome;
        this.qtdPontos = qtdPontos;
    }
    
    @Override
    public int compareTo(TimeFutebol o) {
        if(this.qtdPontos > o.getQtdPontos()) return 1;
        else if(this.qtdPontos == o.getQtdPontos()) return 0;
        else return -1;
    }
    
    public int getQtdPontos(){
        return qtdPontos;
    }
    
    @Override
    public String toString(){
        return nome + "(" + qtdPontos + ")";
    }
}
