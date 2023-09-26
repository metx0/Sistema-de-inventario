import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/* 
Las fechas serán necesarias para que los productos tengan un campo de fecha de caducidad
y para hacer operaciones con las fechas y ordenarlas
Hay distintas clases para trabajas con fechas, en el paquete time
*/

/*
El siguiente código le pide al usuario ingresar una fecha, la parsea, la imprime, y calcula la diferencia
en días de esa fecha a la actual
*/

public class Fechas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate fechaActual = LocalDate.now();

        System.out.print("Ingresa una fecha para parsear (dd-mm-yyyy): ");
        String fechaIngresada = sc.nextLine();
    
        // Definimos el formato para parsearlo e imprimirlo
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 

        // Por si hay excepciones al parsearla
        try {
            LocalDate fecha = LocalDate.parse(fechaIngresada, formatoFecha);
            // Se imprime con el formato definido
            System.out.println("Fecha ingresada: " + fecha.format(formatoFecha));

            // Calcular la diferencia en días entre ese fecha y la actual
            long diferenciaEnDias = ChronoUnit.DAYS.between(fecha, fechaActual);
            System.out.println("La diferencia en días entre esa fecha y la actual es: " + diferenciaEnDias);
        } catch (Exception e) {
            System.out.println("Hubo un error al ingresar la fecha");
        }
    }
}