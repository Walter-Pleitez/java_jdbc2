package outlook.pleitez.jdbc.datos;

import java.sql.*;

public class ConexionBD {
    private static final String jdbc_url = "jdbc:mysql://localhost:3306/java_curso";
    private static final String jdbc_user = "root";
    private static final String jdbc_password = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_password);
    }
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    public static void close(Statement stmt) throws SQLException {
        stmt.close();
    }
    public static void close(PreparedStatement pstmt) throws SQLException {
        pstmt.close();
    }
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }

}
