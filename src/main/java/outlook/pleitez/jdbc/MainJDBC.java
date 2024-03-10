package outlook.pleitez.jdbc;

import java.sql.*;

public class MainJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_curso";

        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "root");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT p.*, c.nombre AS categoria FROM producto AS p " +
            "INNER JOIN categorias AS c ON (p.categoria_id = c.id_categorias)";

            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("id Producto: " + resultado.getInt("id_producto") + " - ");
                System.out.print(" Nombre: " + resultado.getString("nombre") + " - ");
                System.out.print(" Precio: " + resultado.getLong("precio") + " - ");
                System.out.print(" Fecha: " + resultado.getDate("fecha_registro"));
                System.out.println(" ");
            }
            resultado.close();
            instruccion.close();
            conexion.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
