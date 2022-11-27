
package com.mycompany.simercandetc.Modelo;


public class Nota {
    private int id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private int id_asesor;

    public Nota() {
    }

    public Nota(int id, String titulo, String descripcion, String fecha, int id_asesor) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id_asesor = id_asesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_asesor() {
        return id_asesor;
    }

    public void setId_asesor(int id_asesor) {
        this.id_asesor = id_asesor;
    }

    
    
    
    
}
