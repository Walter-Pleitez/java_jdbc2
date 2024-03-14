package outlook.pleitez.jdbc.datos;

import outlook.pleitez.jdbc.domain.ProductoDTO;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import static outlook.pleitez.jdbc.datos.ConexionBD.close;
import static outlook.pleitez.jdbc.datos.ConexionBD.getConnection;

//Realizara las operaciones de Select, Insert o Delete pero sobre clase Producto (Los cambios estaran en BD)
public class ProductoDaoJDBC implements ProductoDao {
    Connection connTransaccional;
    //variable con sentencia SQL
    private static final String sqlSelect = "SELECT id_producto, nombre, precio, fecha_registro FROM producto";
    private static final String sqlInsert = "INSERT INTO producto(nombre, precio, fecha_registro)"+" VALUES(?,?,?)";
    private static final String sqlUpdate = "UPDATE producto SET nombre = ?, precio = ?, fecha_registro= ? WHERE id_producto = ?";
    private static final String sqlDelete = "DELETE FROM producto WHERE id_producto = ?";

    public ProductoDaoJDBC() {
    }
    public ProductoDaoJDBC(Connection connTransaccional) {
        this.connTransaccional = connTransaccional;
    }

    //Metodo que devuelava lista de objetos de tipo producto
    @Override
    public List<ProductoDTO> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ProductoDTO> productos = new ArrayList<>();

        try {
            conn = this.connTransaccional != null ? this.connTransaccional : ConexionBD.getConnection();
            pstmt = conn.prepareStatement(sqlSelect);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id_producto");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                Date fechaRegistro = rs.getDate("fecha_registro");

                ProductoDTO producto = new ProductoDTO(id, nombre, precio, fechaRegistro);
                productos.add(producto);
            }
        }
        finally {
            close(rs);
            close(pstmt);
            if(this.connTransaccional == null){
                close(conn);
            }
        }

        return productos;
    }
    @Override
    public int insertar(ProductoDTO producto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros = 0;
        try {
            conn = this.connTransaccional != null? this.connTransaccional: ConexionBD.getConnection();
            pstmt = conn.prepareStatement(sqlInsert);

            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setDate(3, new Date(producto.getFechaRegistro().getTime()));
            registros = pstmt.executeUpdate();
        } finally {
            try {
                close(pstmt);
                if(this.connTransaccional == null){
                    close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //AGREGAR CANTIDAD DE REGISTROS MODIFICADOS
        return 0;
    }
    @Override
    public int actualizar(ProductoDTO producto) throws SQLException {
        Connection conn = this.connTransaccional != null? this.connTransaccional: ConexionBD.getConnection();
        PreparedStatement pstmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sqlUpdate);

            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setDate(3, new Date(producto.getFechaRegistro().getTime()));
            pstmt.setLong(4, producto.getIdProducto());
            registros = pstmt.executeUpdate();
        } finally {
            try {
                close(pstmt);
                if(this.connTransaccional == null){
                    close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
    @Override
    public int Eliminar(ProductoDTO producto) throws SQLException {
        Connection conn = this.connTransaccional != null? this.connTransaccional: ConexionBD.getConnection();
        PreparedStatement pstmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sqlDelete);

            pstmt.setLong(1, producto.getIdProducto());
            registros = pstmt.executeUpdate();
        } finally {
            try {
                close(pstmt);
                if(this.connTransaccional == null){
                    close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return registros;
    }

}
