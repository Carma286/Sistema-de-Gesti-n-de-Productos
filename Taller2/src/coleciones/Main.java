package coleciones;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GestorProductos gestor = new GestorProductos();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println();
            System.out.println("===== GESTION DE PRODUCTOS =====");
            System.out.println("1. Crear producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Actualizar precio");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = 0; // cualquier valor fuera de 1-5 cae en "default"
            }
            System.out.println();

            switch (opcion) {

                case 1: // CREATE
                    try {
                        System.out.print("ID del producto: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Nombre del producto: ");
                        String nombre = scanner.nextLine().trim();
                        System.out.print("Precio del producto: ");
                        double precio = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));

                        if (nombre.isEmpty() || precio <= 0) {
                            System.out.println("Datos invalidos: el nombre no puede estar vacio "
                                    + "y el precio debe ser mayor que 0.");
                        } else {
                            gestor.agregarProducto(new Producto(id, nombre, precio));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada invalida: el ID y el precio deben ser numeros.");
                    }
                    break;

                case 2: // READ
                    System.out.println("--- Lista de productos ---");
                    gestor.mostrarProductos();
                    break;

                case 3: // UPDATE
                    try {
                        System.out.print("ID del producto a actualizar: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));

                        if (nuevoPrecio <= 0) {
                            System.out.println("El precio debe ser mayor que 0.");
                        } else if (gestor.actualizarProducto(id, nuevoPrecio)) {
                            System.out.println("Precio actualizado correctamente.");
                        } else {
                            System.out.println("No existe un producto con el ID " + id + ".");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada invalida: el ID y el precio deben ser numeros.");
                    }
                    break;

                case 4: // DELETE
                    try {
                        System.out.print("ID del producto a eliminar: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());

                        if (gestor.eliminarProducto(id)) {
                            System.out.println("Producto eliminado correctamente.");
                        } else {
                            System.out.println("No existe un producto con el ID " + id + ".");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada invalida: el ID debe ser un numero.");
                    }
                    break;

                case 5:
                    System.out.println("Hasta pronto.");
                    break;

                default:
                    System.out.println("Opcion no valida. Elija un numero del 1 al 5.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
