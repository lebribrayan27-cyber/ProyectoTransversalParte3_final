package Modelo;
public class Inscripcion {
 private int idInscripcion,idAlumno,idMateria;private Double nota;private boolean activo;
 public Inscripcion(int idInscripcion,int idAlumno,int idMateria,Double nota,boolean activo){this.idInscripcion=idInscripcion;this.idAlumno=idAlumno;this.idMateria=idMateria;this.nota=nota;this.activo=activo;}
 public int getIdInscripcion(){return idInscripcion;}public int getIdAlumno(){return idAlumno;}public int getIdMateria(){return idMateria;}public Double getNota(){return nota;}public boolean isActivo(){return activo;}
}
