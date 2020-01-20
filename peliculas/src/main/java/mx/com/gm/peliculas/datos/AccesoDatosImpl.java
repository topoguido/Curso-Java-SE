/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;

/**
 *
 * @author Emiliano
 */
public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        
        File archivo = new File(nombreArchivo);
        
        return archivo.exists();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) {
        
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList();
        
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(nombreArchivo));
            String linea = null;
            
            linea = entrada.readLine();
            
            while(linea !=null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            
            entrada.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        
        File archivo = new File(nombreArchivo);
        
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            //salida.println(pelicula.toString());
            salida.println(pelicula.getNombre().toString());
            salida.close();
            
            System.out.println("Se ha escrito correctamente el archivo");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            
            linea = entrada.readLine();
            int i = 1;
            while(linea != null){
                
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula: " + linea + " encontrada en la posicion " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) {
        
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("El archivo se ha creado correctamente");
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("El archivo se ha borrado correctamente");
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
