package usp.questao3;

public class Questao3 {

    public static void main(String[] args) {
        Atendimento at = new Atendimento();
        Chamado[] chamados = {  new Chamado("Febre","comum"),
                                new Chamado("Acidente de moto","critico"),
                                new Chamado("Gripe","comum"),
                                new Chamado("Quebrou a perna", "critico")};
        
        for(Chamado c : chamados){
            if(c.getPrioridade().equals("comum")) at.add(c);
            else if(c.getPrioridade().equals("critico")) at.push(c);
        }
        System.out.println("Fila de atendimento: ");
        at.printDeque();
        System.out.println();
        
        System.out.println("Chamado atendido: " + at.remove());
        System.out.println("Fila de atendimento: ");
        at.printDeque();
        System.out.println();
        
        System.out.println("Chamado atendido: " + at.remove());
        System.out.println("Fila de atendimento: ");
        at.printDeque();
        System.out.println();
    }
}
