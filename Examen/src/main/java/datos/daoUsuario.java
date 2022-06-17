/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import cine.controlador.ClsUsuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoUsuario {

    private static final String SQL_SELECT = "SELECT idUsuarios , Usuario, Password, estado FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(Usuario, Password, estado) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET Usuario=?, Password=?, estado=? WHERE idUsuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE idUsuario=?";
    private static final String SQL_QUERY = "SELECT idUsuarios , Usuario, Password, estado FROM usuarios WHERE Usuario = ?";

    public List<ClsUsuarios> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsUsuarios usuario = null;
        List<ClsUsuarios> usuarios = new ArrayList<ClsUsuarios>();
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuarios");
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                int estado = rs.getInt("estado");

                usuario = new ClsUsuarios();
                usuario.setidUsuario(idUsuario);
                usuario.setUsuario(Username);
                usuario.setPassword(Password);
                usuario.setestado(estado);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(ClsUsuarios usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }

    public int update(ClsUsuarios usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getidUsuario());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }

    public int delete(ClsUsuarios usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ClsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidUsuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }

    public ClsUsuarios query(ClsUsuarios usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ClsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, usuario.getUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuarios");
                String Usuario = rs.getString("Usuario");
                String Password = rs.getString("Password");
                int estado = rs.getInt("estado");

                usuario = new ClsUsuarios();
                usuario.setidUsuario(idUsuario);
                usuario.setUsuario(Usuario);
                usuario.setPassword(Password);
                usuario.setestado(estado);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
}
