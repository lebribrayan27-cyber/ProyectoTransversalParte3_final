package Persistencia;
import Modelo.Alumno;import java.sql.*;import java.util.*;
public class AlumnoData {
 public List<Alumno> listar() throws SQLException {List<Alumno> r=new ArrayList<>();try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM alumno ORDER BY idAlumno");ResultSet s=p.executeQuery()){while(s.next())r.add(new Alumno(s.getInt("idAlumno"),s.getInt("dni"),s.getString("apellido"),s.getString("nombre"),s.getBoolean("activo")));}return r;}
 public void insertar(Alumno a)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("INSERT INTO alumno(dni,apellido,nombre,activo) VALUES(?,?,?,?)")){p.setInt(1,a.getDni());p.setString(2,a.getApellido());p.setString(3,a.getNombre());p.setBoolean(4,a.isActivo());p.executeUpdate();}}
 public void actualizar(Alumno a)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("UPDATE alumno SET dni=?,apellido=?,nombre=?,activo=? WHERE idAlumno=?")){p.setInt(1,a.getDni());p.setString(2,a.getApellido());p.setString(3,a.getNombre());p.setBoolean(4,a.isActivo());p.setInt(5,a.getIdAlumno());p.executeUpdate();}}
 public void estado(int id,boolean activo)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("UPDATE alumno SET activo=? WHERE idAlumno=?")){p.setBoolean(1,activo);p.setInt(2,id);p.executeUpdate();}}
 public void borrar(int id)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM alumno WHERE idAlumno=?")){p.setInt(1,id);p.executeUpdate();}}
}
