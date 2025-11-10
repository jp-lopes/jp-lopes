package usp.questao1;

public class Questao1 {

    public static void main(String[] args) {
        
        Comparador<Integer> cInt = new Comparador<>(22 , 23);
        System.out.println(cInt);
        
        Comparador<Double> cDouble = new Comparador<>(0.012 , 0.013);
        System.out.println(cDouble);
        
        Comparador<Float> cFloat = new Comparador<>(0.5f , 0.5f);
        System.out.println(cFloat);
        
        Produto p1 = new Produto("Geladeira", 2969.99);
        Produto p2 = new Produto("Agua", 2.00);
        Produto p3 = new Produto("Agua2", 2.00);
        
        Comparador<Produto> cProduto = new Comparador<>(p1,p2);
        System.out.println(cProduto);
        
        Comparador<Produto> cProduto2 = new Comparador<>(p2,p3);
        System.out.println(cProduto2);
        
    }
}
