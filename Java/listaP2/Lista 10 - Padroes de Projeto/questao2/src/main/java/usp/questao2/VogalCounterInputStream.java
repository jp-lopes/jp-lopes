package usp.questao2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class VogalCounterInputStream extends FilterInputStream {
    private static final char[] vogais = "aeiouAEIOU".toCharArray();
    private int qtdVogais = 0;
    
    public VogalCounterInputStream(InputStream in){
        super(in);
    }
    
    @Override
    public int read() throws IOException{
        int byteLido = in.read();
        if(byteLido != -1){
            char charLido = (char)byteLido;
            for(char vogal : vogais){
                if(charLido == vogal){
                    qtdVogais++;
                    break;
                }
            }
        }
        return byteLido;
    }
    
    public int getTotalVogaisLidas(){
        return qtdVogais;
    }
    
}
