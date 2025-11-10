package usp.questao9;

public class AcrescimoTaxa extends DividaDecorator {
    public AcrescimoTaxa(Divida decorado){
        super(decorado);
    }
    
    @Override
    public String getDesc(){
        return decorado.getDesc() + " com acrescimo de taxa";
    }
    
    @Override
    public double getValor(){
        return decorado.getValor() + 10;
    }
}
