package com.example.musicstore.Recycler;

public class DataUserBase {
    private String id;
    private String nombre;
    private String apellido;
    private String usuario;


    public DataUserBase(String id, String nombre, String apellido, String usuario){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;

    }
    public DataUserBase(){

    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}

