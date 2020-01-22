/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.sql.*;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GE0022
 */
public class UsuarioJDBC {
    
    public static final String SQL_SELECT = "SELECT ID_USUARIO, USUARIO, PASSWORD FROM USUARIOS";
    public static final String SQL_INSERT = "INSERT INTO USUARIOS (USUARIO,PASSWORD) VALUES (?,?)";
    public static final String SQL_DELETE = "DELETE USUARIOS WHERE ID_USUARIO = ?";
    public static final String SQL_UPDATE = "UPDATE USUARIOS SET USUARIO = ?, PASSWORD = ? WHERE ID_USUARIO = ?";
    private static final String SQL_SELECT_NOMBRE = "SELECT ID_USUARIO, USUARO, PASSWORD FROM USUARIO WHERE USUARIO = ?";
    
    public List<Usuario> select(){
        
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario = new Usuario();
        try {
            
            cn = Conexion.getConnection();
            st = cn.prepareStatement(SQL_SELECT);
            rs = st.executeQuery();
            
            while(rs.next()){
               
             usuario.setId_usuario(rs.getInt(0));
             usuario.setUsuario(rs.getString(1));
             usuario.setPassword(rs.getString(2));
             
             usuarios.add(usuario);
             
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally{
            Conexion.close(cn);
            Conexion.close(st);
            Conexion.close(rs);
        }
        return usuarios;
    }
    
    public int insert(Usuario usuario){
        Connection cn = null;
        PreparedStatement st = null;
        int resultado = 0;
        
        try {
            cn = Conexion.getConnection();
            st = cn.prepareStatement(SQL_INSERT);
            st.setString(0, usuario.getUsuario());
            st.setString(1, usuario.getPassword());
            resultado = st.executeUpdate();
            
            System.out.println("Registros afectados: " + resultado);
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally{
            Conexion.close(cn);
            Conexion.close(st);
        }
                
        return resultado;
    }
    
    public int update(Usuario usuario){
        Connection cn = null;
        PreparedStatement st = null;
        int resultado = 0;
        
        try {
            cn = Conexion.getConnection();
            st = cn.prepareStatement(SQL_UPDATE);
            
            st.setString(0, usuario.getUsuario());
            st.setString(1, usuario.getPassword());
            st.setInt(2, usuario.getId_usuario());
            resultado = st.executeUpdate();
            
            System.out.println("Registros afectados: " + resultado);
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally{
            Conexion.close(cn);
            Conexion.close(st);
        }
                
        return resultado;
    }
    
    public int delete(Usuario usuario){
        Connection cn = null;
        PreparedStatement st = null;
        int resultado = 0;
        
        try {
                cn = Conexion.getConnection();
                st = cn.prepareStatement(SQL_DELETE);
                
                st.setInt(0,usuario.getId_usuario());
                
                resultado = st.executeUpdate();
                
                System.out.println("Registros borrados: " + resultado);
                
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally{
            Conexion.close(cn);
            Conexion.close(st);
        }
        return resultado;
    }
    
    public Usuario select_usuario(String nombreUsuario){
        
        Usuario usuario = new Usuario();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            
            cn = Conexion.getConnection();
            st = cn.prepareStatement(SQL_SELECT_NOMBRE);
            
            st.setString(0, nombreUsuario);
            
            rs = st.executeQuery();
            
            usuario.setId_usuario(rs.getInt(0));
            usuario.setUsuario(rs.getString(1));
            usuario.setPassword(rs.getString(2));
            
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally{
            Conexion.close(cn);
            Conexion.close(st);
            Conexion.close(rs);
        }
        
        return usuario;
    }
}
