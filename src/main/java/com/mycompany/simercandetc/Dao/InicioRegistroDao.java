package com.mycompany.simercandetc.Dao;

import com.mycompany.simercandetc.Config.conexion;
import com.mycompany.simercandetc.Modelo.Asesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioRegistroDao extends conexion {
    
   
    
    public boolean guardar(Asesor as) {

        Connection con = getConection();
        PreparedStatement ps;
        String sql = "INSERT INTO asesor (documento,nombre,apellido,correo,password,rol,passCorreo) VALUES (?,?,?,?,?,?,?)";

        String rol = "user";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, as.getDocumento());
            ps.setString(2, as.getNombre());
            ps.setString(3, as.getApellido());
            ps.setString(4, as.getCorreo());
            ps.setString(5, as.getPassword());
            ps.setString(6, rol);
            ps.setString(7, as.getContraseña());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(InicioRegistroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public boolean ingresar(String user,String pass){
        Connection con = getConection();
        PreparedStatement ps=null;
        ResultSet rs;
        String sql = "SELECT id,correo, password FROM asesor WHERE correo='"+user+"' AND password='"+pass+"'";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
            
            return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(InicioRegistroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    public List enId(String user,String pass){
         Connection con = getConection();
        PreparedStatement ps=null;
        ResultSet rs;
        List<Asesor>datos= new ArrayList<>();
        String sql = "SELECT id,correo, password FROM asesor WHERE correo='"+user+"' AND password='"+pass+"'";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Asesor as = new Asesor();
                
                as.setId(rs.getInt(1));
                datos.add(as);
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }finally{
             try {
                 con.close();
             } catch (SQLException ex) {
                 Logger.getLogger(InicioRegistroDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return datos;
    }
    public boolean valAd(String pass) {
        Connection con = getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT nombre FROM asesor WHERE password='" + pass + "' AND rol= 'admin'";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return  false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(InicioRegistroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
