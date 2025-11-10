package usp.questao9;

public class Desconto extends DividaDecorator {
    public Desconto(Divida decorado){
        super(decorado);
    }
    
    @Override
    public String getDesc(){
        return decorado.getDesc() + " com desconto";
    }
    
    @Override
    public double getValor(){
        return decorado.getValor() * 0.9;
    }
}
