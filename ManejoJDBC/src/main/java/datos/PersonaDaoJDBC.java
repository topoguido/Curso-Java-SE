package datos;


import domain.PersonaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDaoJDBC implements PersonaDAO{  
    private Connection conexionTran;
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM personas";
    private static final String SQL_INSERT = "INSERT INTO personas(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE personas SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM personas WHERE id_persona=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_persona, nombre, apellido, email, telefono FROM personas WHERE NOMBRE = ?";
    
    public PersonaDaoJDBC(){
        
    }
    
    public PersonaDaoJDBC(Connection conexionTran) {
        this.conexionTran = conexionTran;
    }
    
    public List<PersonaDTO> select() throws SQLException{
        Connection cn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
        
        try {
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            conexionTran = Conexion.getConnection();
            stmt = conexionTran.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                persona = new PersonaDTO();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                
                personas.add(persona);
            }
            
        } 
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTran == null){
                Conexion.close(conexionTran);
            }
        }
        
        return personas;
    }
    
    public int insert(PersonaDTO persona) throws SQLException{
        Connection cn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            stmt = cn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } 
        finally{
            Conexion.close(stmt);
            if(this.conexionTran == null){
                Conexion.close(cn);
            }
        }
        
        return rows;
    }
    
    public int update(PersonaDTO persona) throws SQLException{
        Connection cn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = cn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getId_persona());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
            
        } 
        finally{
            Conexion.close(stmt);
            if (this.conexionTran == null){
                Conexion.close(cn);
            }
            
        }
        
        return rows;
    }
    
    public int delete(PersonaDTO persona) throws SQLException{
        Connection cn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = cn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        
        }
        finally{
            Conexion.close(stmt);
            if(this.conexionTran == null){
                Conexion.close(cn);
            }
        }
        
        return rows;
    }
    
    public PersonaDTO select_nombre(String nombre) throws SQLException{
        
        PersonaDTO persona = new PersonaDTO();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            
            cn =  this.conexionTran != null ? this.conexionTran : Conexion.getConnection();
            st = cn.prepareStatement(SQL_SELECT_NOMBRE);
            
            st.setString(1, nombre);
            
            rs = st.executeQuery();
            
            if(rs.next()){
                System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE);           
                persona.setId_persona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                persona.setEmail(rs.getString(4));
                persona.setTelefono(rs.getString(5));
            
            }
        }
        finally{
            if (this.conexionTran == null){
                Conexion.close(cn);
            }
            Conexion.close(st);
            Conexion.close(rs);
        }
        
        return persona;
    }
}
