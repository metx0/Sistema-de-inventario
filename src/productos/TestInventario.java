package productos;

import productos.Inventario;
import productos.Producto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Test de las clases Producto e Inventario
*/

public class TestInventario {
	public static void main(String[] args) {
		// La fecha actual del momento
		LocalDate fechaActual = LocalDate.now();
		// El formato de las fechas de caducidad
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 

		// Crearemos varios productos y los añadiremos al inventario
		Producto leche = new Producto("leche", 1, 10, 20.5, LocalDate.of(2023, 12, 13));
		Producto azucar = new Producto("Azucar", 2, 30, 20.5, LocalDate.of(2023, 5, 13));
		Producto panBimbo = new Producto("pan Bimbo", 3);
		Producto jugoReca = new Producto("jugo Reca", 4);

		Inventario invt = new Inventario();
                invt.ordenarProductos();
		invt.agregarProducto(leche);
		invt.agregarProducto(azucar);

		invt.imprimirInventario();
	}
}