package com.mycompany.simercandetc.Controlador;

import com.mycompany.simercandetc.Dao.plantillaDao;
import com.mycompany.simercandetc.Modelo.Plantilla;
import com.mycompany.simercandetc.Vista.vistaPlantilla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControladorVistaPlantilla implements ActionListener {

    private vistaPlantilla vPlan;
    private plantillaDao pDao;
    private Plantilla plan;

    public ControladorVistaPlantilla() {
        this.vPlan = new vistaPlantilla();
        this.plan = new Plantilla();
        this.pDao = new plantillaDao();
        this.vPlan.btnAgregar.addActionListener(this);
    }

    public void mostrar() {
        vPlan.setVisible(true);
        vPlan.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vPlan.btnAgregar) {
            String ruta = vPlan.jtRuta.getText();
            archivoTexto(ruta);

        }
    }

    public void archivoTexto(String ruta) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String contenido = "";
        String titulo = vPlan.jtTitulo.getText();
        try {

            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            while ((contenido = br.readLine()) != null) {
                System.out.println(contenido);

                plan.setNombre(titulo);
                plan.setContenido(contenido);

                if (pDao.guardarPlantilla(plan)) {
                    JOptionPane.showMessageDialog(null, "SE GUARDO LA PLANTILLA");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE GUARDO LA PLANTILLA");
                    limpiar();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void limpiar() {
        vPlan.jtRuta.setText("");
        vPlan.jtTitulo.setText("");
    }
}
