package Persistencia;
import Modelo.Inscripcion;import java.sql.*;import java.util.*;
public class InscripcionData {
 public List<Inscripcion> listar()throws SQLException{List<Inscripcion> r=new ArrayList<>();try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM inscripcion ORDER BY idInscripcion");ResultSet s=p.executeQuery()){while(s.next()){double n=s.getDouble("nota");r.add(new Inscripcion(s.getInt("idInscripcion"),s.getInt("idAlumno"),s.getInt("idMateria"),s.wasNull()?null:n,s.getBoolean("activo")));}}return r;}
 public void inscribir(int a,int m)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("INSERT INTO inscripcion(idAlumno,idMateria,activo) VALUES(?,?,1) ON DUPLICATE KEY UPDATE activo=1")){p.setInt(1,a);p.setInt(2,m);p.executeUpdate();}}
 public void anular(int a,int m)throws SQLException{try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("UPDATE inscripcion SET activo=0 WHERE idAlumno=? AND idMateria=?")){p.setInt(1,a);p.setInt(2,m);p.executeUpdate();}}
 public void cargarNota(int id,double nota)throws SQLException{if(nota<0||nota>10)throw new IllegalArgumentException("La nota debe estar entre 0 y 10");try(Connection c=Conexion.getConnection();PreparedStatement p=c.prepareStatement("UPDATE inscripcion SET nota=? WHERE idInscripcion=? AND activo=1")){p.setDouble(1,nota);p.setInt(2,id);if(p.executeUpdate()==0)throw new SQLException("La inscripcion no esta activa");}}
}
