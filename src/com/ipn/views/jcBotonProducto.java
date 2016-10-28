package com.ipn.views;

import com.ipn.model.beans.Carrito;
import com.ipn.model.beans.Compra;
import com.ipn.model.beans.Producto;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class jcBotonProducto extends JPanel implements ActionListener {
    private DefaultTableModel modelo;
    private Producto producto;
    private int index = 1;
    private int existenciasActuales = 0;
    private String existencias[] = new String[100]; 
    //Nos sirve para almacenar a los objetos creados
    private Map nota = new HashMap();
    private ImageIcon otroicon;
    private Carrito  carrito;
    
    public jcBotonProducto()
    {
        this.setSize(600, 600);
        this.setVisible(true);
        this.setLayout( new FlowLayout() );
    }

    public void Mi_Componente(Producto p,DefaultTableModel modelo ,Carrito c)
    {   
        
        this.modelo = modelo;
        this.carrito = c;
        producto = p;
        System.out.println(producto.getNombre());
        //instancia nueva a componente
        jpBotonProducto jpc = new jpBotonProducto(index);
        jpc.btnProducto.addActionListener(this);//escucha eventos
        if(p.getPhoto() != null){
            ImageIcon icon = new ImageIcon(producto.getPhoto());
            // ImageIcon icon = new ImageIcon(getClass().getResource(p.getImagen));
            Image img = icon.getImage(); //convertimos icon en una imagen
            Image otraimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dándole las dimensiones que queramos a la antigua
            otroicon = new ImageIcon(otraimg);
            
            jpc.btnProducto.setIcon(otroicon);
        }
        
        this.add(jpc);//se añade al jpanel
        this.validate();
        //se añade al MAP
        this.nota.put(index, jpc );
        //se incrementa contador de componentes
        index++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int aux_cantidad;
        Compra compra=null;
        //se obtiene el comando ejecutado
        //Mostrar detalles de producto
        String comando = e.getActionCommand();
        //se recorre el MAP
        Iterator it = nota.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            //se obtiene el KEY -> identificador unico
            String itm = entry.getKey().toString();
            //si comando de componente es igual a comando pulsado
            if( itm.equals(comando))
            {
                //se recupera el contenido del JTextfield
                //mostramos resultado
                int i,j;
                existenciasActuales = producto.getExistencias();
                
                for(j=0,i=existenciasActuales; i>0; i--,j++){
                    existencias[j] = String.valueOf(i);
                }
                System.out.println(producto.getNombre());
                String resp = (String) JOptionPane.showInputDialog(null,producto.getNombre()+
                        "\n Descripcion: "+producto.getDescripcion()+
                        "\n Existencias: "+producto.getExistencias()+
                        "\n Cantidad a comprar: ",producto.getNombre(), JOptionPane.DEFAULT_OPTION, otroicon,existencias,existencias[0]);
                if(resp != null){
                int cantidad = Integer.parseInt(resp);
                System.out.println("Cantidad a comprar : "+cantidad);
                compra = new Compra(producto.getId(),cantidad,producto.getExistencias()-cantidad);
                
                modelo.addRow(new Object[]{producto.getId(),producto.getNombre(),cantidad,producto.getPrecio()});
                carrito.add(producto , compra);
                }
                
            }
            
        }
    }

}
