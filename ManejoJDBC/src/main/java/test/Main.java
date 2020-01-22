package test;

import datos.PersonaJDBC;
import datos.UsuarioJDBC;
import domain.Persona;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.MenuPersonas;
import menu.MenuPrincipal;
import menu.MenuUsuarios;

public class Main {
    
    public static void main(String[] args) { 
        
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuPersonas menuPersonas = new MenuPersonas();
        MenuUsuarios menuUsuarios = new MenuUsuarios();
        
        int opcion = -1;
        Scanner scanner = new Scanner(System.in );
        opcion = menuPrincipal.imprimir();
        
        while(opcion != 0){
            
            switch(opcion){
                case 1:
                    String nombrePersona =null;
                    Persona persona = new Persona();
                    PersonaJDBC personaJDBC = new PersonaJDBC();
                    opcion = menuPersonas.imprimir();
                    while(opcion != 0){

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

                                personaJDBC.insert(persona);

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
                                personaJDBC.delete(persona);

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

                                personaJDBC.update(persona);
                                break;
                        } // fin switch
                    } //fin while
                    break;
                
                case 2:
                    // Menu usuarios
                    String nombreUsuario = null;
                    UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
                    Usuario usuario = new Usuario();
                    opcion = menuUsuarios.imprimir();
                    
                    while(opcion != 0){
                        switch(opcion){
                            case 1:
                                // crear usuario
                                System.out.println("Ingrese el usuario: ");
                                usuario.setUsuario(scanner.nextLine());
                                System.out.println("Ingrese el password: ");
                                usuario.setPassword(scanner.nextLine());
                                
                                usuarioJDBC.insert(usuario);
                                
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
                                usuarioJDBC.delete(usuario);
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
                                
                                usuarioJDBC.update(usuario);
                                break;
                        }
                        
                    }
                    
                    break;
                    
            }
        }
        PersonaJDBC personaJDBC = new PersonaJDBC();
        List<Persona> personas = personaJDBC.select();
        
        for(Persona persona: personas){
            System.out.println("persona:" + persona);
        }
        
        //Prueba insert
//        Persona persona = new Persona();
//        persona.setNombre("Maria");
//        persona.setApellido("Lara");
//        persona.setEmail("mlara@mail.com");
//        persona.setTelefono("55668899");

//        personaJDBC.insert(persona);
      
//        //Prueba update
//        Persona persona = new Persona();
//        persona.setId_persona(3);
//        persona.setNombre("Mayra");
//        persona.setApellido("Lara");
//        persona.setEmail("mlara@mail.com");
//        persona.setTelefono("55668899");
//        
//        personaJDBC.update(persona);

          Persona persona = new Persona();
          persona.setId_persona(3);
          
          personaJDBC.delete(persona);
    }
}
