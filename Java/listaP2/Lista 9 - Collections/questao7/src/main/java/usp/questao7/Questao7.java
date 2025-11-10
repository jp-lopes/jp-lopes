package usp.questao7;

import java.util.ArrayList;
import java.util.Comparator;

public class Questao7 {
    public static void ordenarProdutos(ArrayList<Produto> array, String atributo){
        if(atributo.equals("desc")){
            array.sort(new Comparator<Produto>(){
                @Override
                public int compare(Produto p1, Produto p2){
                    return p1.getDesc().compareTo(p2.getDesc());
                }
            });
        }
        else if(atributo.equals("preco")){
            array.sort(new Comparator<Produto>(){
                @Override
                public int compare(Produto p1, Produto p2){
                    if(p1.getPreco() > p2.getPreco()) return 1;
                    else if(p1.getPreco() == p2.getPreco()) return 0;
                    else return -1;
                }
            });
        }
        else if(atributo.equals("popularidade")){
            array.sort(new Comparator<Produto>(){
                @Override
                public int compare(Produto p1, Produto p2){
                    if(p1.getPopularidade() > p2.getPopularidade()) return 1;
                    else if(p1.getPopularidade() == p2.getPopularidade()) return 0;
                    else return -1;
                }
            });
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        
        produtos.add(new Produto("Mouse Pad", 19.99f, 5));
        produtos.add(new Produto("Teclado Mecanico", 250.00f, 15));
        produtos.add(new Produto("Monitor LED", 850.50f, 8));
        produtos.add(new Produto("Webcam HD", 120.00f, 12));
        produtos.add(new Produto("Armario", 250.00f, 7));
        
        ordenarProdutos(produtos,"desc");
        System.out.println("Ordenado pela descricao: ");
        for(Produto p : produtos) System.out.print(p + ", ");
        System.out.println();
        
        ordenarProdutos(produtos,"preco");
        System.out.println("Ordenado pelo preco: ");
        for(Produto p : produtos) System.out.print(p + ", ");
        System.out.println();
        
        ordenarProdutos(produtos,"popularidade");
        System.out.println("Ordenado pela popularidade: ");
        for(Produto p : produtos) System.out.print(p + ", ");
        System.out.println();
        
    }
}