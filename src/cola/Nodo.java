package cola;

import productos.Producto;

public class Nodo {
    // El nodo contiene un objeto Producto
    private Producto producto;
    // La referencia al siguiente nodo
    private Nodo siguiente;

    // Pasamos el dato que contiene el nodo en el constructor
    public Nodo(Producto producto) {
        this.producto = producto;
    }

    // Getters y setters

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
