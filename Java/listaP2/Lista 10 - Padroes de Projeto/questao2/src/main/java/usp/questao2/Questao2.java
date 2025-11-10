package usp.questao2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class Questao2 {
    public static void main(String[] args) {
        try{
            FileInputStream is = new FileInputStream("textobacana.zip");
            ZipInputStream zip = new ZipInputStream(is);
            zip.getNextEntry();
            VogalCounterInputStream contadorVogais = new VogalCounterInputStream(zip);
            int byteLido = contadorVogais.read();
            System.out.print("Conteudo do txt: \"");
            while(byteLido != -1){ 
                System.out.print((char)byteLido);
                byteLido = contadorVogais.read();
            }
            System.out.println("\"");
            System.out.println("Vogais lidas: " + contadorVogais.getTotalVogaisLidas());
            contadorVogais.close();
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
            
     
    }
}
