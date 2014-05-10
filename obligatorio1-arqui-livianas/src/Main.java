
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.dao.hibernate.BarcoDaoImpl;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Barco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author viti
 */
public class Main {
    public static void main(String[] args) {
        try {
            BarcoDao bdao = new BarcoDaoImpl();
            System.out.print(bdao.obtenerTodos());
        } catch (GenericException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void s() throws GenericException{
        throw new GenericException("<< Exception >>>>>>>>>>>>>>>>");
    }
}
