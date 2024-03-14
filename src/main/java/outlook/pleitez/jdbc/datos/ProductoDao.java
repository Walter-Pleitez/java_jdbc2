package outlook.pleitez.jdbc.datos;

import outlook.pleitez.jdbc.domain.ProductoDTO;

import java.sql.SQLException;
import java.util.List;

public interface ProductoDao {
    //Metodo que devuelava lista de objetos de tipo producto
    public List<ProductoDTO> seleccionar() throws SQLException;

    public int insertar(ProductoDTO producto) throws SQLException;

    public int actualizar(ProductoDTO producto) throws SQLException;

    public int Eliminar(ProductoDTO producto) throws SQLException;
}
