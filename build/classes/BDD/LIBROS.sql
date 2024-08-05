/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  USER
 * Created: 5 ago. 2024
 */
CREATE DATABASE Biblioteca;

USE Biblioteca;

CREATE TABLE Autores (
    idAutor INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    fechaNace DATE NOT NULL
);

CREATE TABLE Libros (
    idLibro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    autorId INT,
    FOREIGN KEY (autorId) REFERENCES Autores(idAutor)
);

