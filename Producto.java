package creadorcsv;

/**
 *
 * @author anton
 */
public class Producto {
    private String nombre;
    private int id;
    private double valor_de_venta;
    private String fecha_de_caducidad;

    public Producto(String nombre, int id, double valor_de_venta, String fecha_de_caducidad) {
        this.nombre = nombre;
        this.id = id;
        this.valor_de_venta = valor_de_venta;
        this.fecha_de_caducidad = fecha_de_caducidad;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor_de_venta() {
        return valor_de_venta;
    }

    public void setValor_de_venta(double valor_de_venta) {
        this.valor_de_venta = valor_de_venta;
    }

    public String getFecha_de_caducidad() {
        return fecha_de_caducidad;
    }

    public void setFecha_de_caducidad(String fecha_de_caducidad) {
        this.fecha_de_caducidad = fecha_de_caducidad;
    }
    
    public String [] getArray() {
        String[] datos = {
            nombre, String.valueOf(id), String.valueOf(valor_de_venta),fecha_de_caducidad
        };
        return datos;
    }
    
}
