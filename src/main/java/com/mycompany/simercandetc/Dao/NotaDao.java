package com.mycompany.simercandetc.Dao;

import com.mycompany.simercandetc.Config.conexion;
import com.mycompany.simercandetc.Modelo.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaDao extends conexion {

    public boolean guardar(Nota not) {

        Connection con = getConection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO nota (titulo,descripcion,fecha,id_asesor) VALUES (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, not.getTitulo());
            ps.setString(2, not.getDescripcion());
            ps.setString(3, not.getFecha());
            ps.setInt(4, not.getId_asesor());
            ps.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public List recordatorio(int id, String fecha) {
        Connection con = getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Nota> datos = new ArrayList<>();
        String sql = "SELECT titulo,descripcion,fecha FROM nota WHERE id_asesor='" + id + "' AND fecha='" + fecha + "'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Nota not = new Nota();
                
                not.setTitulo(rs.getString(1));
                not.setDescripcion(rs.getString(2));
                not.setFecha(rs.getString(3));
                datos.add(not);
                
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NotaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }

}
