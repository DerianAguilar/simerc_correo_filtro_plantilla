
package com.mycompany.simercandetc.Controlador;

import com.mycompany.simercandetc.Dao.EnCorreoDao;
import com.mycompany.simercandetc.Modelo.Contacto;
import com.mycompany.simercandetc.Vista.VistaEnCorreo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorVistaEnCorreo implements ActionListener{

    private VistaEnCorreo vec;
    private EnCorreoDao enDao;
    private ControladorVistaDesCorreo ctrlDesCorreo;
    private String id;

    public ControladorVistaEnCorreo() {
        this.vec=new VistaEnCorreo();
        this.enDao=new EnCorreoDao();
        this.ctrlDesCorreo= new ControladorVistaDesCorreo();
        this.vec.btnBuscar.addActionListener(this);
        this.vec.btnSiguiente.addActionListener(this);
    }
    
    
    
    public void mostrar(String idU){
        this.id=idU;
        vec.setLocationRelativeTo(null);
        vec.setVisible(true);
        vec.txtIdU.setText(idU);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vec.btnBuscar){
            buscar();
        }
        if(e.getSource()==vec.btnSiguiente){
            siguiente();
        }
    }
    
    public void buscar(){
        String buscar= vec.jtBuscar.getText();
        DefaultTableModel modelo = new DefaultTableModel();
        List<Contacto>lista= enDao.buscar(buscar);
        
        modelo.addColumn("ID");
        modelo.addColumn("DOCUMENTO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("CORREO");
        
        vec.tablaCorreo.setModel(modelo);
        
        Object[]object= new Object[5];
        for(int i=0;i<lista.size();i++){
            object[0]=lista.get(i).getId();
            object[1]=lista.get(i).getDocumento();
            object[2]=lista.get(i).getNombre();
            object[3]=lista.get(i).getApellido();
            object[4]=lista.get(i).getCorreo();
            modelo.addRow(object);
        }
        vec.tablaCorreo.setModel(modelo);
        
        
    }
    
    public void siguiente(){
        String idU= vec.txtIdU.getText();
        String idF= vec.txtidFila.getText();
        
        ctrlDesCorreo.mostrar(idU, idF);
        vec.dispose();
    }
}
