import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/*
Esta clase representa una colección de distintos productos
Proporciona los métodos para ordenar dichos productos según su fecha de caducidad y así consumirlos

Autor: Miguel Alejandro Torruco
*/

public class Inventario {
	// La lista de productos se implementa con un arraylist
	private ArrayList<Producto> listaProductos = new ArrayList<>();
	// El formato de las fechas de caducidad
	private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 

	// Añadir un producto al inventario
	// TODO: si se quiere agregar un producto con un ID igual a uno existente, no lo hace
	// a menos que la fecha de caducidad sea distinta
	public void agregarProductos(Producto... productos) {
		for (Producto prod : productos) {
			listaProductos.add(prod);
		}
	}

	// Imprimir el inventario con cada producto
	public void imprimirInventario() {
		// Para cada producto de la lista, imprime el nombre y fecha de caducidad
		for (Producto producto : listaProductos) {
			// Se imprime bien solo si el producto tiene una fecha de caducidad
			System.out.println(producto.getNombre() + " " + producto.getFechaCaducidad().format(formatoFecha));
		}
	}
}