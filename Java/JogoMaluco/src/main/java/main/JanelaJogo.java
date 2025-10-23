package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

public class JanelaJogo extends JFrame {
    
    public JanelaJogo(PainelJogo painel){
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(painel);
        //this.setLocationRelativeTo(null); //Faz a janela aparecer no meio da tela
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.addWindowFocusListener(new WindowFocusListener(){
            @Override
            public void windowGainedFocus(WindowEvent e) {
                
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                painel.getJogo().windowFocusLost();
            }
            
        });
    }
}
