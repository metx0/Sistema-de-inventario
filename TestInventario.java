/*
Test de las clases Producto e Inventario
*/

public class TestInventario {
	public static void main(String[] args) {
		// Crearemos varios productos y los añadiremos al inventario
		// Los creamos solo con el nombre para que sea más rápidp
		Producto leche = new Producto("leche");
		Producto azucar = new Producto("azucar");
		Producto panBimbo = new Producto("pan Bimbo");
		Producto jugoReca = new Producto("jugo Reca");

		Inventario invt = new Inventario();
		invt.agregarProductos(leche, azucar, panBimbo, jugoReca);
		invt.imprimirInventario();
	}
}