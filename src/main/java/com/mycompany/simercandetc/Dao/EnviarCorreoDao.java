
package com.mycompany.simercandetc.Dao;

import com.mycompany.simercandetc.Config.conexion;
import com.mycompany.simercandetc.Modelo.Asesor;
import com.mycompany.simercandetc.Modelo.Contacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EnviarCorreoDao extends conexion{
    
    public List correoE(String idE){
        
        int id= Integer.parseInt(idE);
        Connection con = getConection();
        PreparedStatement ps=null;
        ResultSet rs;
        List<Asesor>datos= new ArrayList<>();
        String sql = "SELECT correo,passCorreo FROM asesor WHERE id="+id;
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Asesor as = new Asesor();
                
                as.setCorreo(rs.getString(1));
                as.setContraseña(rs.getString(2));
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
    
    public List correoR(String idR){
        
        int id = Integer.parseInt(idR);
        Connection con = getConection();
        PreparedStatement ps=null;
        ResultSet rs;
        
        List<Contacto>datos= new ArrayList<>();
        String sql = "SELECT correo,UPPER(nombre) FROM contacto WHERE id="+id;
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Contacto cot = new Contacto();
                
                cot.setCorreo(rs.getString(1));
                cot.setNombre(rs.getString(2));
                datos.add(cot);
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
    
    public List correoTodos(String prog){
        Connection con = getConection();
        PreparedStatement ps=null;
        ResultSet rs;
        
        List<Contacto>datos= new ArrayList<>();
        String sql = "SELECT correo,UPPER(nombre) FROM contacto WHERE programa='"+prog+"'";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Contacto cot = new Contacto();
                
                cot.setCorreo(rs.getString(1));
                cot.setNombre(rs.getString(2));
                datos.add(cot);
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
    
}
