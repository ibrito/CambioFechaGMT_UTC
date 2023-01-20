
# CambioFechaGMT_UTC
Función básica para cambiar de GMT a UTC partiendo de un String con formato

## Librerias
```
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
```

## Funcion Principal
_Esto fechaGTM_UTC() recibe un String con este formato "Fri,13 Jan 2023 19:31:23 GMT"_
```
        public static void main(String[] args) {

                fechaGTM_UTC("Fri,13 Jan 2023 19:31:23 GMT");

        }
```

### Codigo Patron de conversion
```
DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("EEE,dd MMM yyyy HH:mm:ss zzz", Locale.US);
```


### Codigo Operaciones de la función
```
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
```


### Salida
```
Fecha GMT (Texto):Fri,13 Jan 2023 19:31:23 GMT
Objeto fecha con Formato: 2023-01-13T19:31:23
FechaHora GMT: 2023-01-13T19:31:23Z
FechaLocalChile: 2023-01-13T22:31:23Z
Hora Local chile con formato de entrada: Fri,13 Jan 2023 22:31:23 Z
```
