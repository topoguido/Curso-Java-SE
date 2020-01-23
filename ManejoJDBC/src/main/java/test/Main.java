package test;

import datos.Conexion;
import datos.PersonaJDBC;
import datos.UsuarioJDBC;
import domain.Persona;
import domain.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.MenuPersonas;
import menu.MenuPrincipal;
import menu.MenuUsuarios;

public class Main {
    
    public static void main(String[] args) throws IOException { 
        
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuPersonas menuPersonas = new MenuPersonas();
        MenuUsuarios menuUsuarios = new MenuUsuarios();
        Connection cn = null;
        int opcion = -1;
        Scanner scanner = new Scanner(System.in );
        try {
            cn = Conexion.getConnection();
            if(cn.getAutoCommit()){
                cn.setAutoCommit(false);
            }
          
            opcion = menuPrincipal.imprimir();

            while(opcion != 0){

                switch(opcion){
                    case 1:
                        String nombrePersona =null;
                        Persona persona = new Persona();
                        PersonaJDBC personaJDBC = new PersonaJDBC(cn);
                        //opcion = menuPersonas.imprimir();
                        while(opcion != 0){

                            opcion = menuPersonas.imprimir();

                            switch(opcion){
                                // Menu personas
                                case 1:
                                    // agregar persona
                                    System.out.println("Ingrese el nombre: ");
                                    persona.setNombre(scanner.nextLine());
                                    System.out.println("Ingrese el apellido: ");
                                    persona.setApellido(scanner.nextLine());
                                    System.out.println("Ingrese el email: ");
                                    persona.setEmail(scanner.nextLine());
                                    System.out.println("Ingrese el telefono: ");
                                    persona.setTelefono(scanner.nextLine());

                                    if(personaJDBC.insert(persona) >= 0){
                                        cn.commit();
                                    }

                                    break;

                                case 2:
                                    // listar personas
                                    List<Persona> listaPersonas = new ArrayList();
                                    listaPersonas = personaJDBC.select();
                                    for(Persona pers: listaPersonas){
                                        System.out.println(pers.toString());
                                    }
                                    break;

                                case 3:
                                    // borrar persona

                                    System.out.println("Ingrese el nombre de la persona a borrar");
                                    nombrePersona = scanner.nextLine();
                                    persona = personaJDBC.select_nombre(nombrePersona);
                                    if(personaJDBC.delete(persona) >= 0){
                                        cn.commit();
                                    }

                                    break;

                                case 4:
                                    // actualizar persona
                                    System.out.println("Ingrese el nombre de la persona a actualizar");
                                    nombrePersona = scanner.nextLine();
                                    persona = personaJDBC.select_nombre(nombrePersona);
                                    System.out.println("Ingrese el apellido: ");
                                    persona.setApellido(scanner.nextLine());
                                    System.out.println("Ingrese el email: ");
                                    persona.setEmail(scanner.nextLine());
                                    System.out.println("Ingrese el telefono: ");
                                    persona.setTelefono(scanner.nextLine());

                                    if(personaJDBC.update(persona) >= 0){
                                        cn.commit();
                                    }
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("La opcion ingresada no es correcta");

                            } // fin switch
                        } //fin while
                        break;

                    case 2:
                        // Menu usuarios
                        String nombreUsuario = null;
                        UsuarioJDBC usuarioJDBC = new UsuarioJDBC(cn);
                        Usuario usuario = new Usuario();
                        //opcion = menuUsuarios.imprimir();

                        while(opcion != 0){

                            opcion = menuUsuarios.imprimir();

                            switch(opcion){
                                case 1:
                                    // crear usuario
                                    System.out.println("Ingrese el usuario: ");
                                    usuario.setUsuario(scanner.nextLine());
                                    System.out.println("Ingrese el password: ");
                                    usuario.setPassword(scanner.nextLine());

                                    if(usuarioJDBC.insert(usuario) >= 0){
                                        cn.commit();
                                    }

                                    break;

                                case 2:
                                    // listar usuarios
                                    List<Usuario> lista = new ArrayList();
                                    lista = usuarioJDBC.select();

                                    for( Usuario usuarioObj: lista){
                                        System.out.println("Usuario: " + usuarioObj.getUsuario());
                                    }

                                    break;

                                case 3:
                                    // borrar usuario
                                    System.out.println("Ingrese el usuario a borrar:  ");
                                    usuario.setUsuario(scanner.nextLine());
                                    usuario = usuarioJDBC.select_usuario(usuario.getUsuario());
                                    if(usuarioJDBC.delete(usuario) >= 0){
                                        cn.commit();
                                    }
                                    break;
                                case 4:
                                    // actualizar usuario
                                    System.out.println("Ingrese el usuario a actualizar:  ");
                                    usuario.setUsuario(scanner.nextLine());
                                    usuario = usuarioJDBC.select_usuario(usuario.getUsuario());
                                    System.out.println("Ingrese el nuevo usuario:");
                                    usuario.setUsuario(scanner.nextLine());
                                    System.out.println("Ingrese el password: ");
                                    usuario.setPassword(scanner.nextLine());

                                    if( usuarioJDBC.update(usuario) >= 0 ){
                                        cn.commit();
                                    }
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("La opcion ingresada no es correcta");
                            }

                        }

                        break;

                }

                opcion = menuPrincipal.imprimir();
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                cn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
}
