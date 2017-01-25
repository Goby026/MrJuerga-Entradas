package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    protected Connection conexion;
    //JDBC driver nombre y base de datos
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL ="jdbc:mysql://192.168.0.45:3306/mrjuerga_bak";
// private final String DB_URL ="jdbc:mysql://localhost/mrjuerga_bak";
    //Credenciales de bd
//    private final String USER = "root";
//    private final String PASS = "";
    private final String USER = "fofo";
    private final String PASS = "wasufofo15";

    public void conectar() throws Exception {
        try {
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            throw e;
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }

}
