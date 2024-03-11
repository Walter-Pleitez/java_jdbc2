package outlook.pleitez.jdbc;

import outlook.pleitez.jdbc.datos.ProductoDAO;
import outlook.pleitez.jdbc.domain.Producto;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class MainJDBCManejo {
    public static void main(String[] args) throws SQLException {
        ProductoDAO productoDAO = new ProductoDAO();

        //INSERTANDO UN NUEVO OBJETO DE TIPO PRODUCTO
        Producto productoNuevo = new Producto("Jabon Liquido", 1.25, new Date());
        productoDAO.insertar(productoNuevo);

        List<Producto> productos = productoDAO.seleccionar();

        for(Producto producto: productos){
            System.out.println("Producto -> " + producto);
        }

    }
}
