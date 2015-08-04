
package juegodedamas;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author JhonFrayser
 */
public class JuegoDeDamas  extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
          try {

                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            } catch (Exception e) {
            }
        JFrame frame = new JFrame("Juego de Damas - JhonFrayser ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         DamaGUI chessWindow = new DamaGUI();
        frame.setContentPane(chessWindow.createGUI(frame));
        frame.addWindowFocusListener(chessWindow);
        
       
        frame.setSize(550,650);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
        
    }
}
