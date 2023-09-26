import java.time.LocalDate;

/*
Esta clase representa un producto de un inventario

Autor: Miguel Alejandro Torruco
*/
public class Producto {
	private String nombre;
	private int id;
	// Cuántas unidades del producto hay
	private int stock;
	private int precio;
	private LocalDate fechaCaducidad;

	public Producto(String nombre) {
		this.nombre = nombre;
	}

	public Producto(String nombre, int id, int stock, int precio, LocalDate fechaCaducidad) {
		this.nombre = nombre;
		this.id = id;
		this.stock = stock;
		this.precio = precio;
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setStock(int nuevoStock) {
		stock = nuevoStock;
	}

	// TODO: Getters y setters de los demás atributos
}