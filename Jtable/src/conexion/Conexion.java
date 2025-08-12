package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String nombreBd = Propiedades.get("nombre_bd");
    private String usuario = Propiedades.get("usuario_bd");
    private String password = Propiedades.get("clave_bd");
    private String url = Propiedades.get("url_bd");
    private String driver = Propiedades.get("driver_bd");

    static Connection conn = null;

    public Conexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("✅ Conexión exitosa a la BD: " + nombreBd);
            } else {
                System.out.println("❌ No se pudo conectar a la BD: " + nombreBd);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver (" + driver + ")");
        } catch (SQLException e) {
            System.out.println("Error de conexión a la URL: " + url);
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("Verifique que MySQL esté encendido y la BD exista.");
        }
    }

    public static Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
    }
}


