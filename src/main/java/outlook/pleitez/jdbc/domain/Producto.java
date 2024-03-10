package outlook.pleitez.jdbc.domain;

import java.util.Date;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private Double precio;
    private Date fechaRegistro;

    public Producto() {
    }
    //Eliminar por Id
    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    //Para Insertar un nuevo objeto
    public Producto(String nombreProducto, Double precio, Date fechaRegistro) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }
    //Para Modificar un registro
    public Producto(int idProducto, String nombreProducto, Double precio, Date fechaRegistro) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
