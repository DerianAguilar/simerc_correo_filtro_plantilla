
package com.mycompany.simercandetc.Dao;

import com.mycompany.simercandetc.Config.conexion;
import com.mycompany.simercandetc.Modelo.Contacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EnCorreoDao extends conexion{
    
    public List buscar(String buscar){
        Connection con = getConection();
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        List<Contacto> datos = new ArrayList<>();
        String sql="SELECT id,documento,nombre,apellido,correo FROM contacto WHERE documento LIKE'%"+buscar+"%' OR nombre LIKE '%"+buscar+"%' OR apellido LIKE '%"+buscar+"%'";
        
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Contacto cot = new Contacto();
                
                cot.setId(rs.getInt(1));
                cot.setDocumento(rs.getString(2));
                cot.setNombre(rs.getString(3));
                cot.setApellido(rs.getString(4));
                cot.setCorreo(rs.getString(5));
                datos.add(cot);
                
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EnCorreoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
}
