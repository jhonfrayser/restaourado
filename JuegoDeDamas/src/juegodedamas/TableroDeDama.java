package juegodedamas;

import java.util.*;
import java.awt.*;
/**
 *
 * @author JhonFrayser
 */
public class TableroDeDama extends Canvas {
    
 // Crear Objeto
     protected objPaintInstruction currentInstruction = null;
     protected Vector vecPaintInstructions = new Vector();
     
    public void tablerodamas() {
    }
    
//  Usar Objetos y Crear Procedimientos y Funciones
    public void update(Graphics g) {
        paint(g);
    }
    
    
    ////////////
     public void paint(Graphics g) {
        
        if (vecPaintInstructions.size() == 0) {
            
            g.setColor(new Color(75,141,221)); //Estable los colores al tablero
            g.fillRect(0,0,500,50);//Borde norte
            g.fillRect(0,0,50,500);//Oeste
            g.fillRect(0,450,500,50);//Sur
            g.fillRect(450,0,50,500);//este
            
            currentInstruction = new objPaintInstruction(0,0,8);
            vecPaintInstructions.addElement(currentInstruction);
            
        }
        
        g.setColor(new Color(75,141,221));
        g.fillRect(50,450,450,50);
        
        for (int i = 0; i < vecPaintInstructions.size(); i++) {
            
            currentInstruction = (objPaintInstruction)vecPaintInstructions.elementAt(i);
            int startRow = currentInstruction.getStartRow();
            int startColumn = currentInstruction.getStartColumn();
            int rowCells = currentInstruction.getRowCells();
            int columnCells = currentInstruction.getColumnCells();
            
            for (int row = startRow; row < (startRow + rowCells); row++) {
                
                for (int column = startColumn; column < (startColumn + columnCells); column++) {
                    drawTile(row, column, g);
                }
                
            }
            
        }
        
        drawExtra(g);
        
    }
    //////////
     
        //Dibuja y Pinta el Tablero---------------------
    private void drawTile(int row, int column, Graphics g) {
        
        if ((row + 1) % 2 == 0) {
            
            if ((column + 1) % 2 == 0) {
                g.setColor(new Color(255,255,255));
            } else {
                g.setColor(new Color(0,0,0));
            }
            
        } else {
            
            if ((column + 1) % 2 == 0) {
                g.setColor(new Color(0,0,0));
            } else {
                g.setColor(new Color(255,255,255));
            }
            
        }
        
        g.fillRect((50 + (column * 50)), (50 + (row * 50)), 50, 50);
        
    }
    
    //Hace visible a las imagenes
    protected void drawExtra(Graphics g) {
    }
    
     //Permite Seleccionar  ----
    protected int findWhichTileSelected(int coor) {
        
        for (int i = 0; i < 8; i++) {
            
            if ((coor >= (50 + (i * 50))) && (coor <= (100 + (i * 50)))) {
                return i;
            }
            
        }
        
        return -1;
        
    }
    
    
}
