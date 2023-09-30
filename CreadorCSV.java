import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author anton
 */
public class CreadorCSV {
    
    //Detecta si existe un archivo con nombreArchivo (el mismo de nombreArchivoBase)
    public static boolean archivoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Crear un ArrayList de productos
        ArrayList<Producto> productos = new ArrayList<>();

        /* Agregar productos al ArrayList, en esta parte desde la interfaz se pueden añadir
        productos con add, aca un ejemplo
        productos.add(new Producto("Producto A", 1, 50, "26-09-2023"));
        productos.add(new Producto("Producto B", 2, 134.50, "27-09-2023"));
        productos.add(new Producto("Producto C", 3, 12.99, "28-09-2023"));
        productos.add(new Producto("Producto D", 4, 345, "29-09-2023"));
        */
        
        // Nombre base del archivo
        String nombreArchivoBase = "productos_testeo.csv";
        String nombreArchivo = nombreArchivoBase;
        int contador = 1;

        // Verifica si un archivo existe, si ya hay uno asi, se le agrega un numero 
        while (archivoExiste(nombreArchivo)) {
            nombreArchivo = nombreArchivoBase.replace(".csv", "_" + contador + ".csv");
            contador++;
        }

        
        //Crea un FileWriter para un archivo CSV
        FileWriter creador_csv = new FileWriter(nombreArchivoBase);       

        // Escribir los datos de los productos en el archivo CSV
        for (Producto producto : productos) {
            //Une los elementos con comas
            String lineaCSV = String.join(",", producto.getArray()); 
            //Utiliza write para escribir la línea
            creador_csv.write(lineaCSV);
            //Agrega un salto de linea después de cada línea
            creador_csv.write(System.lineSeparator());
        }

        // Cerrar el objeto FileWriter
        creador_csv.close();
    }   
}
