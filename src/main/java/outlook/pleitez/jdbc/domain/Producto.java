package outlook.pleitez.jdbc.domain;

import java.util.Date;

//CLASE DE DOMINIO O IDENTIDAD (Tiene representacion en la BD)
public class Producto {
    private Long idProducto;
    private String nombreProducto;
    private Double precio;
    private Date fechaRegistro;

    public Producto() {
    }
    //Eliminar por Id
    public Producto(Long idProducto) {
        this.idProducto = idProducto;
    }
    //Para Insertar un nuevo objeto
    public Producto(String nombreProducto, Double precio, Date fechaRegistro) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }
    //Para Modificar un registro
    public Producto(Long idProducto, String nombreProducto, Double precio, Date fechaRegistro) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
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
