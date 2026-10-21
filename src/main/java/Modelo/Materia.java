package Modelo;
public class Materia {
 private int idMateria;private String nombre,descripcion;private boolean activo;
 public Materia(int idMateria,String nombre,String descripcion,boolean activo){this.idMateria=idMateria;this.nombre=nombre;this.descripcion=descripcion;this.activo=activo;}
 public int getIdMateria(){return idMateria;}public String getNombre(){return nombre;}public String getDescripcion(){return descripcion;}public boolean isActivo(){return activo;}
 public void setIdMateria(int v){idMateria=v;}public void setNombre(String v){nombre=v;}public void setDescripcion(String v){descripcion=v;}public void setActivo(boolean v){activo=v;}
 public String toString(){return nombre;}
}
