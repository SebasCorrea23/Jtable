CREATE DATABASE empleadosdb;

USE empleadosdb;

CREATE TABLE trabajadores (
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(20) NOT NULL PRIMARY KEY,
    cargo VARCHAR(50),
    sueldo DECIMAL(10,2)
);
INSERT INTO trabajadores (nombre, documento, cargo, sueldo)
VALUES
('Juan Pérez', '123456789', 'Gerente', 3500000),
('María López', '987654321', 'Analista', 2500000);

