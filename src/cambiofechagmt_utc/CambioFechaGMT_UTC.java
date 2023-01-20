
package cambiofechagmt_utc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author irving brito
 */
public class CambioFechaGMT_UTC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        fechaGTM_UTC("Fri,13 Jan 2023 19:31:23 GMT");
        
    }
    
    public static void fechaGTM_UTC(String fechaStrGMT) {
        
         String fechaTextoGMT=fechaStrGMT;
        System.out.println("Fecha GMT (Texto):"+fechaTextoGMT);
        
        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("EEE,dd MMM yyyy HH:mm:ss zzz", Locale.US);
        
        
        LocalDateTime horaLocal=LocalDateTime.parse(fechaTextoGMT, formatoFecha);
        System.out.println("Objeto fecha con Formato: "+horaLocal);
       
        
        //hora GMT
        Instant fechaInstantaneaGMT= horaLocal.atZone(ZoneId.of("GMT")).toInstant();
        System.out.println("FechaHora GMT: "+fechaInstantaneaGMT);
        
        //hora UTC
        Instant fechaInstantaneaUTC= horaLocal.atZone(ZoneId.of("America/Santiago")).toInstant();
        System.out.println("FechaLocalChile: "+fechaInstantaneaUTC);
        
        
        ZonedDateTime fechaLocalUTC= ZonedDateTime.parse(fechaInstantaneaUTC.toString());
        
        System.out.println("Hora Local chile con formato de entrada: "+fechaLocalUTC.format(formatoFecha));
        
    }//FIN fechaGTM_UTC()
    
}//FIN CambioFechaGMT_UTC
