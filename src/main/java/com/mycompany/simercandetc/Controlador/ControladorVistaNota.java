package com.mycompany.simercandetc.Controlador;

import com.mycompany.simercandetc.Dao.NotaDao;
import com.mycompany.simercandetc.Modelo.Nota;
import com.mycompany.simercandetc.Vista.VistaNotas;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorVistaNota {

    private VistaNotas vN;
    private Nota nota;
    private NotaDao nDao;

    private String idU;
    private int id;

    public ControladorVistaNota() {
        this.vN = new VistaNotas();
        this.nota = new Nota();
        this.nDao = new NotaDao();
    }

    public void mostrar(String id) {
        this.idU = id;
        vN.setVisible(true);
        vN.setLocationRelativeTo(null);
        vN.idU.setText(id);
        vN.btnSig.setVisible(false);
        vN.btnAtras.setVisible(false);
        desc();

    }

    public void guardar(String ttl, String desc, String fecha, int id) {

        nota.setTitulo(ttl);
        nota.setDescripcion(desc);
        nota.setFecha(fecha);
        nota.setId_asesor(id);

        if (nDao.guardar(nota)) {
            JOptionPane.showMessageDialog(null, "SE GUARDO EL RECORDATORIO");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "NO SE GUARDO EL RECORDATORIO");
            limpiar();
        }
        //vN.jtTitulo.setText("");
        //vN.jtDescripcion.setText("");

    }

    public void limpiar() {
        vN.jtTitulo.setText("");
        vN.jtDescripcion.setText("");
    }

    public void desc() {
        int id = Integer.parseInt(vN.idU.getText());
        String titulo = "";
        String desc = "";
        //NotaDao nDao= new NotaDao();
        LocalDate fecha = LocalDate.now();

        String fech = String.valueOf(fecha);
        List<Nota> lista = nDao.recordatorio(id, fech);
        for (int i = 0; i < lista.size(); i++) {
            titulo = lista.get(0).getTitulo();
            desc = lista.get(0).getDescripcion();
        }

        vN.txtTitulo.setText(titulo);
        vN.txtDesc.setText(desc);
        if (lista.size() != 0) {
            vN.btnSig.setVisible(true);
        } else {
            vN.btnSig.setVisible(false);
        }
    }

}
