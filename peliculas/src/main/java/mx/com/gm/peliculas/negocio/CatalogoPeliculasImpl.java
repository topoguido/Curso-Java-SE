/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.peliculas.negocio;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author Emiliano
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos;
    
    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
    
      
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try{
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula, nombreArchivo, anexar);
            
            
        } catch (AccesoDatosEx ex) {
            System.out.println("No se pudo agregar la pelicula. Error de acceso a datos");
            ex.printStackTrace();
        }
    }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   @Override
    public void listarPeliculas(String nombreArchivo) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            List<Pelicula> lista = datos.listar(nombreArchivo);
            for(Pelicula pelicula : lista){
                System.out.println("Pelicula " + pelicula);
            }   

        }catch(AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();   
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String nombrePelicula) {
        
        Pelicula pelicula = new Pelicula(nombrePelicula);
        String resultado = null;
        try {
            resultado = datos.buscar(nombreArchivo, resultado);
            
        } catch(LecturaDatosEx ex){
            System.out.println("Error al buscar la pelicula");
            ex.printStackTrace();
        }
        System.out.println("Resultado busqueda:" + resultado);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            }
            else{
                datos.crear(nombreArchivo);
            }
            
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
