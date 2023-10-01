package productos;

import java.time.LocalDate;
import java.util.ArrayList;

/*
Esta clase representa una colección de distintos productos
Proporciona los métodos para ordenar dichos productos según su fecha de caducidad y así consumirlos

Autor: Miguel Alejandro Torruco
 */
public class Inventario {
    // La lista de productos se implementa con un arraylist
    public ArrayList<Producto> listaProductos = new ArrayList<>();
    // La fecha actual del momento
    private LocalDate fechaActual = LocalDate.now();
    
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /*
	Los distintos lotes se tratan con IDs diferentes; por ejemplo, un lote diferente de leche se trata
	con un ID diferente ya que tiene una fecha de caducidad distinta
        Devolvemos números enteros según el resultado de la función. Solo el 3 indica éxito
        1: id existente
        2: fecha inválida
        3: éxito
     */
    public int agregarProducto(Producto productoNuevo) {
        boolean idExistente = false;

        for (Producto producto : listaProductos) {
            if (productoNuevo.getId() == producto.getId()) {
                idExistente = true;
                break;
            }
        }

        if (idExistente) {
            System.out.println("Ya existe un producto con ese ID");
            return 1;
        }

        LocalDate fechaCaducidad = productoNuevo.getFechaCaducidad();

        // Comprobamos si el producto tiene una fecha de caducidad mayor a la fecha actual
        if (fechaCaducidad.isAfter(fechaActual)) {
            listaProductos.add(productoNuevo);
            return 3;
        } else {
            System.out.println("La fecha de caducidad del producto no es valida");
            return 2;
        }
    }

    /*
	Ordena los productos de "listaProductos" según sus fechas de caducidad: los más próximos a vencer van
	al inicio. Toma en cuenta si son productos con el mismo nombre 
     */
    public void ordenarProductos() {
        // Ordenar los productos de menor a mayor según su fecha de caducidad, usando el algoritmo bubble sort
        boolean intercambio;

        while (true) {
            intercambio = false;

            for (int i = 0; i < listaProductos.size() - 1; i++) {
                // Recuperamos las referencias de los productos que queremos comparar
                Producto productoActual = listaProductos.get(i);
                Producto productoSiguiente = listaProductos.get(i + 1);

                // Si la fecha del producto actual es mayor a la fecha del producto siguiente
                if (productoActual.getFechaCaducidad().isAfter(productoSiguiente.getFechaCaducidad())) {
                    /* 
                    Intercambiamos los valores con el método set()
                    Toma dos argumentos: el primero es el índice de la posición en la que deseas realizar 
                    la modificación, y el segundo es el nuevo elemento que deseas asignar a esa posición.
                    En este caso, queremos poner en la posición i el elemento de i + 1
                    y en la posición i + 1 el elemento de la posición i
                     */

                    listaProductos.set(i, productoSiguiente);
                    listaProductos.set(i + 1, productoActual);

                    intercambio = true;
                }
            }

            // Si no hay intercambio en la iteración, todos los productos están ordenados
            if (!intercambio) {
                break;
            }
        }
    }

    // Método para test; no imprime todos los atributos
    public void imprimirInventario() {
        // Para cada producto de la lista, imprime el nombre y la fecha de caducidad
        for (Producto producto : listaProductos) {
            System.out.println(producto.getNombre() + " " + producto.getFechaCaducidad().format(producto.getFormatoFecha()));
        }
    }
}