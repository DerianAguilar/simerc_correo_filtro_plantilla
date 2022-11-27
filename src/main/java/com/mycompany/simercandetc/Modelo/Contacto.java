package com.mycompany.simercandetc.Modelo;

public class Contacto {

    private int id;
    private String tipoDocumento;
    private String documento;
    private String nombre;
    private String apellido;
    private String correo;
    private String colegio;
    private String direccion;
    private String telefono;
    private String nacionalidad;
    private String modalidad;
    private int asesor;
    private String programa;
    private String observaciones;
    private String nAs;
    private String apAs;

    public Contacto() {
    }

    public Contacto(int id, String tipoDocumento, String documento, String nombre, String apellido, String correo, String colegio, String direccion, String telefono, String nacionalidad, String modalidad, int asesor, String programa, String observaciones, String nAs, String apAs) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.colegio = colegio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.modalidad = modalidad;
        this.asesor = asesor;
        this.programa = programa;
        this.observaciones = observaciones;
        this.nAs = nAs;
        this.apAs = apAs;
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getAsesor() {
        return asesor;
    }

    public void setAsesor(int asesor) {
        this.asesor = asesor;
    }

    public String getnAs() {
        return nAs;
    }

    public void setnAs(String nAs) {
        this.nAs = nAs;
    }

    public String getApAs() {
        return apAs;
    }

    public void setApAs(String apAs) {
        this.apAs = apAs;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    

}
