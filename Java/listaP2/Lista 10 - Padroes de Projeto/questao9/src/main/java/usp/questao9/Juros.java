package usp.questao9;

public class Juros extends DividaDecorator {
    public Juros(Divida decorado){
        super(decorado);
    }
    
    @Override
    public String getDesc(){
        return decorado.getDesc() + " com juros";
    }
    
    @Override
    public double getValor(){
        return decorado.getValor() * 1.5;
    }
    
}
