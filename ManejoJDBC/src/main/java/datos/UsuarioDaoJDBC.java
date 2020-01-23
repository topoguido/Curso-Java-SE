/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.sql.*;
import domain.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GE0022
 */
public class UsuarioDaoJDBC implements UsuarioDAO{
    
    private Connection conexionTran;
    public static final String SQL_SELECT = "SELECT ID_USUARIO, USUARIO, PASSWORD FROM USUARIOS";
    public static final String SQL_INSERT = "INSERT INTO USUARIOS (USUARIO,PASSWORD) VALUES (?,?)";
    public static final String SQL_DELETE = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";
    public static final String SQL_UPDATE = "UPDATE USUARIOS SET USUARIO = ?, PASSWORD = ? WHERE ID_USUARIO = ?";
    private static final String SQL_SELECT_USUARIO = "SELECT ID_USUARIO, USUARIO, PASSWORD FROM USUARIOS WHERE USUARIO = ?";

    public UsuarioDaoJDBC(Connection conexionTran) {
        this.conexionTran = conexionTran;
    }
    
    public UsuarioDaoJDBC(){
        
    }
    
    public List<UsuarioDTO> select() throws SQLException{
        
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
        
        try {
            
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            st = cn.prepareStatement(SQL_SELECT);
            rs = st.executeQuery();
            
            while(rs.next()){
             
             UsuarioDTO usuario = new UsuarioDTO();
             usuario.setId_usuario(rs.getInt(1));
             usuario.setUsuario(rs.getString(2));
             usuario.setPassword(rs.getString(3));
             
             usuarios.add(usuario);
             
            }
        }
        finally{
            if(this.conexionTran == null){
                Conexion.close(cn);
            }
            Conexion.close(st);
            Conexion.close(rs);
        }
        return usuarios;
    }
    
    public int insert(UsuarioDTO usuario) throws SQLException{
        Connection cn = null;
        PreparedStatement st = null;
        int resultado = 0;
        
        try {
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            st = cn.prepareStatement(SQL_INSERT);
            st.setString(1, usuario.getUsuario());
            st.setString(2, usuario.getPassword());
            resultado = st.executeUpdate();
            
            System.out.println("Registros afectados: " + resultado);
        }
        finally{
            if(this.conexionTran == null){
                Conexion.close(cn);
            }
            Conexion.close(st);
        }
                
        return resultado;
    }
    
    public int update(UsuarioDTO usuario) throws SQLException{
        Connection cn = null;
        PreparedStatement st = null;
        int resultado = 0;
        
        try {
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            st = cn.prepareStatement(SQL_UPDATE);
            
            st.setString(1, usuario.getUsuario());
            st.setString(2, usuario.getPassword());
            st.setInt(3, usuario.getId_usuario());
            resultado = st.executeUpdate();
            
            System.out.println("Registros afectados: " + resultado);
        }
        finally{
            if(this.conexionTran == null){
                Conexion.close(cn);
            }
            Conexion.close(st);
        }
                
        return resultado;
    }
    
    public int delete(UsuarioDTO usuario) throws SQLException{
        Connection cn = null;
        PreparedStatement st = null;
        int resultado = 0;
        
        try {
                cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
                st = cn.prepareStatement(SQL_DELETE);
                
                st.setInt(1,usuario.getId_usuario());
                
                resultado = st.executeUpdate();
                
                System.out.println("Registros borrados: " + resultado);
                
        }
        finally{
            if(this.conexionTran == null){
               Conexion.close(cn);
            }
            Conexion.close(st);
        }
        return resultado;
    }
    
    public UsuarioDTO select_usuario(String nombreUsuario) throws SQLException{
        
        UsuarioDTO usuario = new UsuarioDTO();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            st = cn.prepareStatement(SQL_SELECT_USUARIO);
            
            st.setString(1, nombreUsuario);
            
            rs = st.executeQuery();
            
            if(rs.next()){
                usuario.setId_usuario(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPassword(rs.getString(3));
            }
        }
        finally{
            if(this.conexionTran == null){
                Conexion.close(cn);
            }
            Conexion.close(st);
            Conexion.close(rs);
        }
        
        return usuario;
    }
}
