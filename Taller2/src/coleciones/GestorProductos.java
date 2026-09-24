package coleciones;

import java.util.ArrayList;

public class GestorProductos {

    private ArrayList<Producto> productos = new ArrayList<>();

    // Registra el producto si es valido y su id no existe todavia
    public void agregarProducto(Producto producto) {
        if (producto == null) {
            System.out.println("Error: producto invalido.");
            return;
        }

        for (Producto existente : productos) {
            if (existente.getId() == producto.getId()) {
                System.out.println("Error: ya existe un producto con el ID " + producto.getId() + ".");
                return;
            }
        }

        productos.add(producto);
        System.out.println("Producto registrado correctamente.");
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    // Devuelve false si no existe un producto con ese id
    public boolean actualizarProducto(int id, double nuevoPrecio) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setPrecio(nuevoPrecio);
                return true;
            }
        }
        return false;
    }

    // Devuelve false si no existe un producto con ese id
    public boolean eliminarProducto(int id) {
        return productos.removeIf(producto -> producto.getId() == id);
    }
}
