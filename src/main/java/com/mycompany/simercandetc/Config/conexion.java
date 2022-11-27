package com.mycompany.simercandetc.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {

    final String bd = "simerc_prueba";
    final String url = "jdbc:mysql://localhost:3306/" + bd;
    final String user = "root";
    final String pass = "";
    final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection con = null;

    public conexion() {
    }

    public Connection getConection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Conectado a la bd");
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}
