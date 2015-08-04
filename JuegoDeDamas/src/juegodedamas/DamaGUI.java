package juegodedamas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
/**
 *
 * @author JhonFrayer
 */
public class DamaGUI implements ActionListener, KeyListener, WindowFocusListener {
    
     private VentanaTablero mainBoard;
    private objCreateAppletImage createImage;
    private JButton cmdNewGame, cmdSetNames;
    private JTextField txtPlayerOne, txtPlayerTwo;
    private JLabel lblPlayerOne, lblPlayerTwo;
    private String[] strNegrasPieces = {"fichaNegra.JPG","DamaNegra.JPG"};
    private String[] strBlancasPieces = {"fichaBlanca.JPG","DamaBlanca.JPG"};
    private Color clrBlue = new Color(75,141,221);
    private MediaTracker mt;
    
    public void chessGUI() {
    }
    
    public Container createGUI(JFrame mainApp) {
        
        JPanel panRoot = new JPanel(new BorderLayout());
        panRoot.setOpaque(true);
        panRoot.setPreferredSize(new Dimension(550,650));
        
        mainBoard = new VentanaTablero();
        createImage = new objCreateAppletImage();
        
        mainBoard.setSize(new Dimension(500, 500));
        
        cmdNewGame = new JButton("Crear nuevo juego");
        cmdSetNames = new JButton("Establecer nombres");
        
        cmdNewGame.addActionListener(this);
        cmdSetNames.addActionListener(this);
        
        txtPlayerOne = new JTextField("GuizadoGonzales", 10);
        txtPlayerTwo = new JTextField("Oponente",10);
        
        txtPlayerOne.addKeyListener(this);
        txtPlayerTwo.addKeyListener(this);
        
        lblPlayerOne = new JLabel("    ", JLabel.RIGHT);
        lblPlayerTwo = new JLabel("    ", JLabel.RIGHT);
        
        try {
            
            Image[] imgNegras = new Image[6];
            Image[] imgBlancas = new Image[6];
            mt = new MediaTracker(mainApp);
            
            for (int i = 0; i < 6; i++) {
                
                imgNegras[i] = createImage.getImage(this, "/images/" + strNegrasPieces[i], 5000);
                imgBlancas[1] = createImage.getImage(this,"/images/" + strBlancasPieces[i], 5000);
                mt.addImage(imgNegras[i], 0);
                mt.addImage(imgBlancas[i], 0);
                
            }
            
            try {
                mt.waitForID(0);
            } catch (InterruptedException e) {
            }
            
            mainBoard.setupImages(imgNegras, imgBlancas);
            
        } catch (NullPointerException e) {
            
            JOptionPane.showMessageDialog(null, "Imposible cargar las imagenes.", "ERROR", JOptionPane.WARNING_MESSAGE);
            cmdNewGame.setEnabled(false);
            cmdSetNames.setEnabled(false);
            e.printStackTrace();
            
        }
        
        JPanel panBottomHalf = new JPanel(new BorderLayout());
        JPanel panNameArea = new JPanel(new GridLayout(3,1,2,2));
        JPanel panPlayerOne = new JPanel();
        JPanel panPlayerTwo = new JPanel();
        JPanel panNameButton = new JPanel();
        JPanel panNewGame = new JPanel();
        
        panRoot.add(mainBoard, BorderLayout.NORTH);
        panRoot.add(panBottomHalf, BorderLayout.SOUTH);
        panBottomHalf.add(panNameArea, BorderLayout.WEST);
        panNameArea.add(panPlayerOne);
        panPlayerOne.add(lblPlayerOne);
        panPlayerOne.add(txtPlayerOne);
        panNameArea.add(panPlayerTwo);
        panPlayerTwo.add(lblPlayerTwo);
        panPlayerTwo.add(txtPlayerTwo);
        panNameArea.add(panNameButton);
        panNameButton.add(cmdSetNames);
        panBottomHalf.add(panNewGame, BorderLayout.SOUTH);
        panNewGame.add(cmdNewGame);
        
        panRoot.setBackground(clrBlue);
        panBottomHalf.setBackground(clrBlue);
        panNameArea.setBackground(clrBlue);
        panPlayerOne.setBackground(clrBlue);
        panPlayerTwo.setBackground(clrBlue);
        panNameButton.setBackground(clrBlue);
        panNewGame.setBackground(clrBlue);
        
        lblPlayerOne.setBackground(new Color(236,17,17));
        lblPlayerTwo.setBackground(new Color(17,27,237));
        
        cmdNewGame.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        return panRoot;
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == cmdSetNames) {
            
            if (txtPlayerOne.getText().equals("")) {
                txtPlayerOne.setText("GuizadoGonzales");
            }
            
            if (txtPlayerTwo.getText().equals("")) {
                txtPlayerTwo.setText("Oponente");
            }
            
            mainBoard.setNames(txtPlayerOne.getText(), txtPlayerTwo.getText());
            
        } else if (e.getSource() == cmdNewGame) {
            mainBoard.newGame();
        }
        
    }
    
    public void keyTyped(KeyEvent e) {
        
        String strBuffer = "";
        char c = e.getKeyChar();
        
        if (e.getSource() == txtPlayerOne) {
            strBuffer = txtPlayerOne.getText();
        } else {
            strBuffer = txtPlayerTwo.getText();
        }
        
        if (strBuffer.length() > 10 && !((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume();
        }
        
    }
    
    public void keyPressed(KeyEvent e) {
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public void windowGainedFocus(WindowEvent e) {
        mainBoard.gotFocus();
    }
    
    public void windowLostFocus(WindowEvent e) {
    }
}
