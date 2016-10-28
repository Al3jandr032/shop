package com.ipn.views;

//import com.ipn.views.jpTablaCompra;
import java.awt.FlowLayout;
//package com.ipn.views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class jcTablaCompra extends JPanel implements ActionListener {

    private int index = 1;
    //Nos sirve para almacenar a los objetos creados
    private Map nota = new HashMap();
    private ImageIcon otroicon;
    public jcTablaCompra()
    {
        this.setVisible(true);
        this.setLayout( new FlowLayout() );
    }

    public void Mi_Componente(/*Producto p*/)
    {        
        //instancia nueva a componente
        //jpTablaCompra jpc = new jpTablaCompra();
      //  this.add(jpc);//se añade al jpanel
        this.validate();
        //se añade al MAP
        //this.nota.put(index, jpc );
        //se incrementa contador de componentes
        index++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //se obtiene el comando ejecutado
        //MOstrar detalles de producto
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
                String existencias[] ={"1","2","3","4"};
                
                String resp = (String) JOptionPane.showInputDialog(null,"Producto "+itm+"\n /*Descripcion*/ \n Existencias: "+"\n Cantidad a comprar: ","Producto "+itm, JOptionPane.DEFAULT_OPTION, otroicon,existencias,existencias[0]);
                
                
            }
            
        }
    }

}
