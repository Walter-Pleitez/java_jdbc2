package outlook.pleitez.jdbc.datos;

import outlook.pleitez.jdbc.domain.Producto;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

//Realizara las operaciones de Select, Insert o Delete pero sobre clase Producto (Los cambios estaran en BD)
public class ProductoDAO {
    //variable con sentencia SQL
    private static final String sqlSelect = "SELECT id_producto, nombre, precio, fecha_registro FROM producto";

    //Metodo que devuelava lista de objetos de tipo producto
    public List<Producto> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();

        try {
            conn = ConexionBD.getConnection();
            pstmt = conn.prepareStatement(sqlSelect);
            rs = pstmt.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id_producto");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                Date fechaRegistro = rs.getDate("fecha_registro");

                Producto producto = new Producto(id, nombre, precio, fechaRegistro);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBD.close(rs);
            ConexionBD.close(pstmt);
            ConexionBD.close(conn);
        }

        return productos;
    }


}
