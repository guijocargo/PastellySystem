/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PastellySystemController;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author USER
 */
public class SplashScreen extends JWindow {

    private int duration;

    public SplashScreen(int d) {
        duration = d;
    }

// Este é um método simples para mostrar uma tela de apresentção
// no centro da tela durante a quantidade de tempo passada no construtor
    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(new Color(254, 254, 204, 255));

        // Configura a posição e o tamanho da janela
        int width = 600;
        int height = 300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Splash 1
        JLabel label = new JLabel(new ImageIcon("C:\\Users\\USER\\Desktop\\"
                + "prjPastellySystem\\src\\resources\\img\\SplashScreen.png"));
        JLabel copyrt = new JLabel("Copyright 2012, Compilers Solutions",
                JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color color = new Color(254, 254, 105, 255);
        content.setBorder(BorderFactory.createLineBorder(color, 10));
        
        // Splash 2
        /*JLabel label = new JLabel(new ImageIcon("C:\\Users\\USER\\Desktop\\"
                + "prjPastellySystem\\src\\resources\\img\\pastelly.png"));
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File("C:\\Users\\USER\\Desktop\\"
                    + "prjPastellySystem\\src\\resources\\img\\pastelly.png"));
        } catch (IOException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        Graphics2D g2D = bi.createGraphics();
        content.paint(g2D);*/
        
        // Torna visível
        setVisible(true);

        // Espera ate que os recursos estejam carregados
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();
        PastellySystemController psc = new PastellySystemController();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen(3000);
        splash.showSplashAndExit();
    }
}
