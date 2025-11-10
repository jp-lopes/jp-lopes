package usp.questao5;

public class Logger {
    private static Logger instance = null;
    
    private Logger(){
    }
    
    public static Logger getInstance(){
        if(instance==null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void registrar(String mensagem){
        System.out.println("Log Message: \"" + mensagem + "\" at [" + System.currentTimeMillis() + "ms]");
    }
    
}
