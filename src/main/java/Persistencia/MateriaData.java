package Persistencia;
import Modelo.Materia;import java.sql.*;import java.util.*;
public class MateriaData {
 public List<Materia> listar()throws SQLException{List<Materia> r=new ArrayList<>();try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM materia ORDER BY idMateria");ResultSet s=p.executeQuery()){while(s.next())r.add(new Materia(s.getInt("idMateria"),s.getString("nombre"),s.getString("descripcion"),s.getBoolean("activo")));}return r;}
 public void insertar(Materia m)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("INSERT INTO materia(nombre,descripcion,activo) VALUES(?,?,?)")){p.setString(1,m.getNombre());p.setString(2,m.getDescripcion());p.setBoolean(3,m.isActivo());p.executeUpdate();}}
 public void actualizar(Materia m)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("UPDATE materia SET nombre=?,descripcion=?,activo=? WHERE idMateria=?")){p.setString(1,m.getNombre());p.setString(2,m.getDescripcion());p.setBoolean(3,m.isActivo());p.setInt(4,m.getIdMateria());p.executeUpdate();}}
 public void estado(int id,boolean activo)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("UPDATE materia SET activo=? WHERE idMateria=?")){p.setBoolean(1,activo);p.setInt(2,id);p.executeUpdate();}}
 public void borrar(int id)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM materia WHERE idMateria=?")){p.setInt(1,id);p.executeUpdate();}}
}
