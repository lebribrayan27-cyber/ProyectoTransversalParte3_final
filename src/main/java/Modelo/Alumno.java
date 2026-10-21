package Modelo;
public class Alumno {
 private int idAlumno,dni; private String apellido,nombre; private boolean activo;
 public Alumno(int idAlumno,int dni,String apellido,String nombre,boolean activo){this.idAlumno=idAlumno;this.dni=dni;this.apellido=apellido;this.nombre=nombre;this.activo=activo;}
 public int getIdAlumno(){return idAlumno;} public int getDni(){return dni;} public String getApellido(){return apellido;} public String getNombre(){return nombre;} public boolean isActivo(){return activo;}
 public void setIdAlumno(int v){idAlumno=v;} public void setDni(int v){dni=v;} public void setApellido(String v){apellido=v;} public void setNombre(String v){nombre=v;} public void setActivo(boolean v){activo=v;}
 public String toString(){return apellido+", "+nombre;}
}
