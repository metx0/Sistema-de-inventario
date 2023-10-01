package cola;

import productos.Producto;

public class ColaSimple {

    // El frente es el único nodo al que se tiene acceso
    private Nodo frente;
    // El tamaño de la cola
    private int longitud;

    // Operaciones de la cola
    public void insertar(Producto producto) {
        Nodo nuevoNodo = new Nodo(producto);

        if (frente == null) {
            frente = nuevoNodo;
        } else {
            Nodo nodoActual = frente;
            // Recorremos la cola
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }

        longitud++;
    }

    public void eliminar() {
        if (estaVacia()) {
            System.out.println("No hay elementos en la cola");
            return;
        }

        frente = frente.getSiguiente();
        longitud--;
    }

    public void imprimirCola() {
        Nodo nodoActual = frente;
        while (nodoActual != null) {
            Producto productoActual = nodoActual.getProducto();
            System.out.println(productoActual.getNombre() + "  " + productoActual.getFechaCaducidad());
            nodoActual = nodoActual.getSiguiente();
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public Nodo getFrente() {
        // Si la cola está vacía
        if (frente == null) {
            System.out.println("No hay elementos en la cola");
            return null;
        }

        return frente;
    }

    public int getLongitud() {
        return longitud;
    }
}