/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Scanner;

/**
 *
 * @author GE0022
 */
public class MenuUsuarios {
    private static final Scanner scanner = new Scanner(System.in);
    
    public int imprimir(){
         
        int opcion = 0;
        System.out.println("1 - Agregar usuario");
        System.out.println("2 - Listar usuarios");
        System.out.println("3 - Borrar usuario");
        System.out.println("4 - Actualizar usuario");
        System.out.println("0 - Volver al menu anterior");
        
        opcion = Integer.parseInt(scanner.nextLine());
        
        return opcion;
    }
}
