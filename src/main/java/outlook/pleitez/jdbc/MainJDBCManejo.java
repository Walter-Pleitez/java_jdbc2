package outlook.pleitez.jdbc;

import outlook.pleitez.jdbc.datos.ConexionBD;
import outlook.pleitez.jdbc.datos.ProductoDAO;
import outlook.pleitez.jdbc.domain.Producto;

import java.sql.*;
import java.util.Date;


public class MainJDBCManejo {
    public static void main(String[] args) throws SQLException {
        Producto producto = null;
        Connection conexion = null;

        try{
            conexion = ConexionBD.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            ProductoDAO productoDAO = new ProductoDAO(conexion);

            Producto cambioProducto = new Producto();
            cambioProducto.setIdProducto(14L);
            cambioProducto.setNombreProducto("Alcohol Gel");
            cambioProducto.setPrecio(5.00);
            cambioProducto.setFechaRegistro( new Date());
            productoDAO.actualizar(cambioProducto);

            Producto nuevoProducto = new Producto();
            nuevoProducto.setNombreProducto("Crema antiarrugas");
            nuevoProducto.setPrecio(1.25);
            nuevoProducto.setFechaRegistro(new Date());
            productoDAO.insertar(nuevoProducto);

            conexion.commit();

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Entramos al Rollback");
            conexion.rollback();
        }
    }
}
