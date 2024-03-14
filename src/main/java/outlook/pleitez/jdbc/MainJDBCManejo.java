package outlook.pleitez.jdbc;

import outlook.pleitez.jdbc.datos.ConexionBD;
import outlook.pleitez.jdbc.datos.ProductoDao;
import outlook.pleitez.jdbc.datos.ProductoDaoJDBC;
import outlook.pleitez.jdbc.domain.ProductoDTO;

import java.sql.*;
import java.util.List;


public class MainJDBCManejo {

    public static void main(String[] args) throws SQLException {
        Connection conexion = null;

        try{
            conexion = ConexionBD.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            ProductoDao productoDAO = new ProductoDaoJDBC(conexion);
            List<ProductoDTO> productos = productoDAO.seleccionar();

            for(ProductoDTO producto: productos){
                System.out.println("Producto: " + producto);
            }

            conexion.commit();
            System.out.println("Se he hecho commit de la transaccion");

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Entramos al Rollback");
            conexion.rollback();
        }
    }
}
