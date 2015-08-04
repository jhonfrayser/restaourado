/*
 *Esta es la Ficha, extiende de la clase pieza para poder usar sus metodos
 *
 */
package juegodedamas;

/**
 *
 * @author hp
 */
public class Ficha extends Pieza {
    
    public void Ficha(){}
    //
    //Movimiento legal 
    public boolean legalMove(int startRow, int startColumn, int desRow, int desColumn, int[][] playerMatrix) {
        
        if (startRow == desRow || startColumn == desColumn) {
            
            strErrorMsg = "Solo se mueven en diagonal";
            return false;
            
        }
        
        //se valida si el movimiento fue en forma diagonal
        return axisMove(startRow, startColumn, desRow, desColumn, playerMatrix, false);
        
    }
        
}
