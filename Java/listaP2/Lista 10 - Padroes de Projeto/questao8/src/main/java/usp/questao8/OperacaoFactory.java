package usp.questao8;

public class OperacaoFactory {
    public static OperacaoEntreConjuntos criar(String tipo){
        switch(tipo.toLowerCase()){
            case "uniao":
                return new Uniao();
            case "interseccao":
                return new Interseccao();
            case "diferenca":
                return new Diferenca();
            default:
                return null;
        }
    }
}
