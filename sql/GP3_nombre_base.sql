CREATE DATABASE IF NOT EXISTS proyecto_transversal CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE proyecto_transversal;
CREATE TABLE IF NOT EXISTS alumno (idAlumno INT AUTO_INCREMENT PRIMARY KEY, dni INT NOT NULL UNIQUE, apellido VARCHAR(100) NOT NULL, nombre VARCHAR(100) NOT NULL, activo TINYINT(1) NOT NULL DEFAULT 1);
CREATE TABLE IF NOT EXISTS materia (idMateria INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL, descripcion VARCHAR(200), activo TINYINT(1) NOT NULL DEFAULT 1);
CREATE TABLE IF NOT EXISTS inscripcion (idInscripcion INT AUTO_INCREMENT PRIMARY KEY, idAlumno INT NOT NULL, idMateria INT NOT NULL, nota DECIMAL(4,2) NULL, activo TINYINT(1) NOT NULL DEFAULT 1, UNIQUE KEY uk_alumno_materia(idAlumno,idMateria), FOREIGN KEY (idAlumno) REFERENCES alumno(idAlumno), FOREIGN KEY (idMateria) REFERENCES materia(idMateria));
INSERT IGNORE INTO alumno(idAlumno,dni,apellido,nombre,activo) VALUES (1,12345678,'Perez','Juan',1),(2,23456789,'Gomez','Ana',1);
INSERT IGNORE INTO materia(idMateria,nombre,descripcion,activo) VALUES (1,'Programacion','Java',1),(2,'Base de Datos','SQL',1);
