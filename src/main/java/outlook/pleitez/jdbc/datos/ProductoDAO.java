package outlook.pleitez.jdbc.datos;

import outlook.pleitez.jdbc.domain.Producto;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import static outlook.pleitez.jdbc.datos.ConexionBD.close;
import static outlook.pleitez.jdbc.datos.ConexionBD.getConnection;

//Realizara las operaciones de Select, Insert o Delete pero sobre clase Producto (Los cambios estaran en BD)
public class ProductoDAO {
    //variable con sentencia SQL
    private static final String sqlSelect = "SELECT id_producto, nombre, precio, fecha_registro FROM producto";
    private static final String sqlInsert = "INSERT INTO producto(nombre, precio, fecha_registro)"+" VALUES(?,?,?)";

    //Metodo que devuelava lista de objetos de tipo producto
    public List<Producto> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();

        try {
            conn = getConnection();
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
            close(rs);
            close(pstmt);
            close(conn);
        }

        return productos;
    }
    public int insertar(Producto producto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sqlInsert);

            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setDate(3, new Date(producto.getFechaRegistro().getTime()));
            registros = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                close(pstmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }


}
