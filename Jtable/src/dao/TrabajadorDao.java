package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import vo.TrabajadorVo;

public class TrabajadorDao {

    public void registrarTrabajador(TrabajadorVo trabajador) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO trabajadores (nombre, documento, cargo, sueldo) VALUES ('"
                    + trabajador.getNombre() + "', '" + trabajador.getDocumento() + "', '"
                    + trabajador.getCargo() + "', " + trabajador.getSueldo() + ")");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al registrar trabajador: " + e.getMessage());
        }
    }

    public List<TrabajadorVo> listarTrabajadores() {
        List<TrabajadorVo> trabajadores = new ArrayList<>();
        Conexion conex = new Conexion();

        try {
            Statement estatuto = conex.getConnection().createStatement();
            ResultSet rs = estatuto.executeQuery("SELECT * FROM trabajadores");

            while (rs.next()) {
                TrabajadorVo t = new TrabajadorVo();
                t.setNombre(rs.getString("nombre"));
                t.setDocumento(rs.getString("documento"));
                t.setCargo(rs.getString("cargo"));
                t.setSueldo(rs.getDouble("sueldo"));
                trabajadores.add(t);
            }

            rs.close();
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al listar trabajadores: " + e.getMessage());
        }

        return trabajadores;
    }

    public void eliminarTrabajador(String documento) {
        Conexion conex = new Conexion();
        try {
            PreparedStatement consulta = conex.getConnection()
                    .prepareStatement("DELETE FROM trabajadores WHERE documento = ?");
            consulta.setString(1, documento);
            consulta.executeUpdate();
            consulta.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar trabajador: " + e.getMessage());
        }
    }
}
