package auxiliar;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadSave {
    public static BufferedImage importarImagem(String nome_da_imagem) { 
        //UM POUCO DIFERENTE DO TUTORIAL, USEI ESSE MODELO: https://stackoverflow.com/questions/36544362/creating-a-sub-image-in-java
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(new java.io.File(".").getCanonicalPath() + Consts.PATH + nome_da_imagem));
        } catch (IOException ex) {
            System.getLogger(LoadSave.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return imagem;
    }
    
    public static int[][] carregarInfoNivel(){
        int[][] infoNivel = new int[Consts.BLOCOS_NA_ALTURA][Consts.BLOCOS_NA_LARGURA];
        BufferedImage imagem = importarImagem("terreno/level1info.png");

        for(int j=0;j<imagem.getHeight();j++){
            for(int i=0;i<imagem.getWidth();i++){
                Color cor = new Color(imagem.getRGB(i, j));
                int valor = cor.getRed();
                if(valor>=48) valor = 0;
                infoNivel[j][i] = valor;
            }
        }
        
        return infoNivel;
    }
}
