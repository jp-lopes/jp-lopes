package usp.questao7;

public class Produto {
    private String desc;
    private float preco;
    private int popularidade;

    public Produto(String desc, float preco, int popularidade) {
        this.desc = desc;
        this.preco = preco;
        this.popularidade = popularidade;
    }

    public String getDesc() {
        return desc;
    }

    public float getPreco() {
        return preco;
    }

    public int getPopularidade() {
        return popularidade;
    }

    @Override
    public String toString() {
        return "{" + desc + ", " + preco + ", " + popularidade + "}";
    }
}
