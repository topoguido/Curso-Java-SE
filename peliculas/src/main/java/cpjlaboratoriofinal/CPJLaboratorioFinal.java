
package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

/**
 *
 * @author Emiliano
 */
public class CPJLaboratorioFinal {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "c:\\users\\GE0022\\Google Drive\\Curso Java\\base-peliculas.txt";
    private static final CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
    
    public static void main(String[] args) {
        
        while(opcion !=0){
            try {
                System.out.println("Elige opcion:");
                System.out.println("1: Iniciar catalogo peliculas.");
                System.out.println("2: Agregar pelicula.");
                System.out.println("3: Listar peliculas.");
                System.out.println("4: Buscar pelicula.");
                System.out.println("0: Salir.");

                opcion = Integer.parseInt(scanner.nextLine());
                switch(opcion){

                    case(1):
                        catalogo.iniciarArchivo(nombreArchivo);
                        break;

                    case(2):
                        System.out.println("Introduzca el nombre de la pelicula: ");
                        catalogo.agregarPelicula(scanner.nextLine(), nombreArchivo);
                        break;

                    case(3):
                        catalogo.listarPeliculas(nombreArchivo);
                        break;

                    case(4):
                        System.out.println("Ingrese el nombre de la pelicula a buscar: ");
                        catalogo.buscarPelicula(nombreArchivo, scanner.nextLine());
                        break;

                    case(0):
                        System.out.println("Adios...");

                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                    }
                }catch (Exception e) {
                    e.printStackTrace();  
            }
        }
    }
}
