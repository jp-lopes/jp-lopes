package usp.questao1;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Questao1 {
    
    public static void EscanearPasta(File fonte){
        if (fonte.exists()) {
            File[] subarquivos = fonte.listFiles();
            
            File[] arquivos_txt = fonte.listFiles(new FilenameFilter(){
                @Override
                public boolean accept(File dir, String name){
                    return name.endsWith(".txt");
                }
            });
            
            for(File txt : arquivos_txt){
                System.out.println(txt.getName());
            }
            
            for(File subarquivo : subarquivos){
                if(subarquivo.isDirectory()){
                    EscanearPasta(subarquivo);
                }
            }
        }
        else System.out.println("Fonte não existe");
    }
    
    
    public static void main(String[] args) throws IOException {
        File fonte = new File("PastaLegal");
        EscanearPasta(fonte);
    }
}
