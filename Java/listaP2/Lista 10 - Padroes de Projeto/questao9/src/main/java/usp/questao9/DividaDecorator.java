package usp.questao9;

public abstract class DividaDecorator extends Divida{
    protected Divida decorado;
    public DividaDecorator(Divida decorado){
        this.decorado = decorado;
    }
}
