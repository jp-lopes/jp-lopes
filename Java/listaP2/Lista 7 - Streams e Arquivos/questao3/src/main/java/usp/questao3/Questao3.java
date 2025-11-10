package usp.questao3;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Questao3 {

    public static void main(String[] args) {
        String nome = "JOAO";
        byte[] array = nome.getBytes();
        ByteArrayInputStream byteInput = new ByteArrayInputStream(array);
        
        File tanque = new File("nome.dat");
        
        if(!tanque.exists()){
            try {
                tanque.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
                return;
            }
        }
        
        try(FileOutputStream fos = new FileOutputStream(tanque)){
            byte[] buffer = new byte[10];
            int lenght = byteInput.read(buffer);
            while(lenght != -1){
                fos.write(buffer,0,lenght);
                lenght = byteInput.read(buffer);
            }
            fos.close();
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
