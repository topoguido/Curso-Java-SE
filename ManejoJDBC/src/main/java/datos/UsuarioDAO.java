/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Emiliano
 */
public interface UsuarioDAO {
    
     public List<UsuarioDTO> select() throws SQLException;
     
     public int insert(UsuarioDTO usuario) throws SQLException;
     
     public int update(UsuarioDTO usuario) throws SQLException;
     
     public int delete(UsuarioDTO usuario) throws SQLException;
     
     public UsuarioDTO select_usuario(String nombreUsuario) throws SQLException;
    
}
