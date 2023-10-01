package productos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Esta clase representa un producto de un inventario

Autor: Miguel Alejandro Torruco
 */
public class Producto {

    private String nombre;
    // Identificar único del producto
    private int id;
    // Cuántas unidades del producto hay
    private int stock;
    private double precio;
    private LocalDate fechaCaducidad;
    // El formato de las fechas de caducidad
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Constructor corto
    public Producto(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Constructor con todos los atributos
    public Producto(String nombre, int id, int stock, double precio, LocalDate fechaCaducidad) {
        this.nombre = nombre;
        this.id = id;
        this.stock = stock;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
    
    public int getStock() {
        return stock;
    }
    
    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    public DateTimeFormatter getFormatoFecha() {
        return formatoFecha;
    }

    public void setStock(int nuevoStock) {
        stock = nuevoStock;
    }

    // La representación del producto como un arreglo de cadenas
    public String[] obtenerDatos() {
        String[] datos = {
            nombre, String.valueOf(id), String.valueOf(stock), String.valueOf(precio),
            fechaCaducidad.format(formatoFecha)
        };

        return datos;
    }
}
