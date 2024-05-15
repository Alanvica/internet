package com.emergentes.modelo;

/**
 *
 * @author Villalba
 */
public class seminario {
    private int id;
    private String nombre;
    private String apellidos;
    private String seminarios;
    private String confimado;
    private String fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(String seminarios) {
        this.seminarios = seminarios;
    }

    public String getConfimado() {
        return confimado;
    }

    public void setConfimado(String confimado) {
        this.confimado = confimado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "seminario{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", seminarios=" + seminarios + ", confimado=" + confimado + ", fecha=" + fecha + '}';
    }
    
    
}
