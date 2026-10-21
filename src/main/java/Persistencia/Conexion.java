package Persistencia;
import java.sql.*;
public class Conexion {
 public static Connection getConnection() throws SQLException {return DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/proyecto_transversal", "root", "");}
}
