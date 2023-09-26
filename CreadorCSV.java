
package creadorcsv;

import com.csvreader.CsvWriter; //https://www.csvreader.com/java_csv.php
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author anton
 */
public class CreadorCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
                // Crear un ArrayList de productos
        ArrayList<Producto> productos = new ArrayList<>();

        // Agregar productos al ArrayList
        productos.add(new Producto("Producto A", 1, 50, "26-09-2023"));
        productos.add(new Producto("Producto B", 2, 134.50, "27-09-2023"));
        productos.add(new Producto("Producto C", 3, 12.99, "28-09-2023"));
        productos.add(new Producto("Producto D", 4, 345, "29-09-2023"));

        // Crear un objeto CsvWriter
        CsvWriter csvWriter = new CsvWriter("productos.csv");

        // Escribir los datos de los productos en el archivo CSV
        for (Producto producto : productos) {
            csvWriter.writeRecord(producto.getArray());
        }

        // Cerrar el objeto CsvWriter
        csvWriter.close();
    }
    
}
