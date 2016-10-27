/*
 */
package shop;

import com.ipn.controllers.Cliente;
import com.ipn.model.beans.Producto;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class ClienteTest {
    public static void main(String args[]){
        try {
            Cliente c = new Cliente("localhost",1921);            
            List<Producto> lst = c.recibirCatalogo();
            for(int i=0;i<lst.size();i++){
                System.out.println((Producto)lst.get(i));
            }
            c.recibirImagenes();
        } catch (IOException ex) {
            Logger.getLogger(ClienteTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
