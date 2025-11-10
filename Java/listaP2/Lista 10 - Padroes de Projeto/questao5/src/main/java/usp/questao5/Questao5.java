package usp.questao5;

public class Questao5 {
    public static void main(String[] args) {
        ModuloPagamento pagamento = new ModuloPagamento();
        ModuloRelatorio relatorio = new ModuloRelatorio();
        ModuloUsuario usuario = new ModuloUsuario();
        
        pagamento.efetuarPagamento();
        relatorio.gerarRelatorio();
        usuario.login();
    }
}
