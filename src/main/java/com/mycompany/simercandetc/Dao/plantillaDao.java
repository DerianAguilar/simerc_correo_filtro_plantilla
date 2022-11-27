
package com.mycompany.simercandetc.Dao;

import com.mycompany.simercandetc.Config.conexion;
import com.mycompany.simercandetc.Modelo.Plantilla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class plantillaDao extends conexion{
    
    public boolean guardarPlantilla(Plantilla plan){
    
    Connection con = getConection();
    PreparedStatement ps =null;
    
    String sql = "INSERT INTO plantilla (nombre,contenido) VALUES (?,?)";
    
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, plan.getNombre());
            ps.setString(2, plan.getContenido());
            ps.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(plantillaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    
}
    
}
