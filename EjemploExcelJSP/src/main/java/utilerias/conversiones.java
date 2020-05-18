/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Emiliano
 */
public class conversiones {
    
    private static final String FORMATO_FECHA = "dd-MM";
    
    public static String format(Date fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        
        return formateador.format(fecha);
    }
    
}
