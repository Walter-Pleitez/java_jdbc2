package outlook.pleitez.jdbc.datos;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;

public class ConexionBD {
    private static final String jdbc_url = "jdbc:mysql://localhost:3306/java_curso";
    private static final String jdbc_user = "root";
    private static final String jdbc_password = "root";

    public static DataSource getDataSource(){
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl(jdbc_url);
        bds.setUsername(jdbc_user);
        bds.setPassword(jdbc_password);
        //SE DEFINE EL SIZE INICIAL PARA EL POOL
        bds.setInitialSize(5);

        return bds;
    };

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
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
