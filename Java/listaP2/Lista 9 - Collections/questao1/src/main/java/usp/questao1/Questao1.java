package usp.questao1;

public class Questao1 {
    public static void main(String[] args) {
        Fila pacientes = new Fila(6);
        if(pacientes.add("Joao")) System.out.println("Novo paciente: Joao");
        if(pacientes.add("Maria")) System.out.println("Novo paciente: Maria");
        if(pacientes.add("Jose")) System.out.println("Novo paciente: Jose");
        if(pacientes.add("Carlos")) System.out.println("Novo paciente: Carlos");
        if(pacientes.add("Pedro")) System.out.println("Novo paciente: Pedro");
        if(pacientes.add("Ana")) System.out.println("Novo paciente: Ana");
        if(pacientes.add("Cristina")) System.out.println("Novo paciente: Cristina");
        
        System.out.println("\nFila atual: ");
        pacientes.printFila();
        
        System.out.println("Paciente Atendido: " + pacientes.poll());
        System.out.println("Paciente Atendido: " + pacientes.poll());
        System.out.println("Paciente Atendido: " + pacientes.poll());
        
        System.out.println("\nFila atual: ");
        pacientes.printFila();
        
        System.out.println("Paciente Atendido: " + pacientes.poll());
        
        System.out.println("\nFila atual: ");
        pacientes.printFila();
        
    }
}
