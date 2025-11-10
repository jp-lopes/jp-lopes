package usp.questao1;

public class Produto implements Comparable<Produto> {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString(){
        return nome + "(R$" + preco + ")";
    }

    public double getPreco(){
        return preco;
    }
    
    @Override
    public int compareTo(Produto p) {
        if (this.preco == p.getPreco()) return 0;
        else if (this.preco > p.getPreco()) return 1;
        else return -1;
    }
    
}
