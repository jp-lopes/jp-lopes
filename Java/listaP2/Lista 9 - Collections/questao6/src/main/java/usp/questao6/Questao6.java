package usp.questao6;

public class Questao6 {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        agenda.adicionarContato("Joao", 992108143);
        agenda.adicionarContato("Maria", 981237643);
        agenda.adicionarContato("Jose", 972346543);
        agenda.adicionarContato("Carlos", 997122435);
        
        System.out.println("Numero do Joao: " + agenda.buscarTelefone("Joao"));
        
        agenda.listarContatos();
    }
}
