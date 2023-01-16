package com.example.musicstore.model;

public class Instrument {
    private int id;
    private String marca;
    private String modelo;
    private String descripcion;
    private String imagen;
    private int precio;
    private int tipoProductoId;
//    private String nombre;
//    id: 1,
//    marca: "marca",
//    modelo: "modelo",
//    descripcion: "descripcion",
//    imagen: "imagen",
//    precio: 20,
//    tipoProductoId: 1,
//    tipo: null

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTipoProductoId() {
        return tipoProductoId;
    }

    public void setTipoProductoId(int tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }


//    public Instrument(String name, String description, int image, String brand) {
//        this.name = name;
//        this.description = description;
//        this.image = image;
//        this.brand = brand;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }
}
