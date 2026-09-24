package coleciones;

import java.util.ArrayList;

public class GestorProductos {

    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public boolean actualizarProducto(int id, double nuevoPrecio) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setPrecio(nuevoPrecio);
                return true;
            }
        }

        return false;
    }

    public boolean eliminarProducto(int id) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
                return true;
            }
        }

        return false;
    }
}