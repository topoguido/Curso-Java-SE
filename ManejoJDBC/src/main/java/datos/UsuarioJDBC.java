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
    public static final String SQL_DELETE = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";
    public static final String SQL_UPDATE = "UPDATE USUARIOS SET USUARIO = ?, PASSWORD = ? WHERE ID_USUARIO = ?";
    private static final String SQL_SELECT_USUARIO = "SELECT ID_USUARIO, USUARIO, PASSWORD FROM USUARIOS WHERE USUARIO = ?";
    
    public List<Usuario> select(){
        
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        try {
            
            cn = Conexion.getConnection();
            st = cn.prepareStatement(SQL_SELECT);
            rs = st.executeQuery();
            
            while(rs.next()){
             
             Usuario usuario = new Usuario();
             usuario.setId_usuario(rs.getInt(1));
             usuario.setUsuario(rs.getString(2));
             usuario.setPassword(rs.getString(3));
             
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
            st.setString(1, usuario.getUsuario());
            st.setString(2, usuario.getPassword());
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
            
            st.setString(1, usuario.getUsuario());
            st.setString(2, usuario.getPassword());
            st.setInt(3, usuario.getId_usuario());
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
                
                st.setInt(1,usuario.getId_usuario());
                
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
            st = cn.prepareStatement(SQL_SELECT_USUARIO);
            
            st.setString(1, nombreUsuario);
            
            rs = st.executeQuery();
            
            if(rs.next()){
                usuario.setId_usuario(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPassword(rs.getString(3));
            }
            
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
