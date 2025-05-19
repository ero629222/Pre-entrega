import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Articulo> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n***************************************");
            System.out.println("*       --- Menú de Artículos ---     *");
            System.out.println("***************************************");
            System.out.println("* 1. Crear artículo                   *");
            System.out.println("* 2. Listar artículos                 *");
            System.out.println("* 3. Modificar artículo               *");
            System.out.println("* 4. Eliminar artículo                *");
            System.out.println("* 5. Salir                            *");
            System.out.println("***************************************");
            System.out.print("► Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> modificarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public static void crearArticulo() {
        System.out.print("► Ingrese el nombre del artículo: ");
        String nombre = sc.nextLine();

        System.out.print("► Ingrese la descripción del artículo: ");
        String descripcion = sc.nextLine();

        System.out.print("► Ingrese el precio del artículo (usar punto para decimales): ");
        double precio = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        Articulo nuevo = new Articulo(nombre, descripcion, precio);
        lista.add(nuevo);
        System.out.println("✓ Artículo agregado con éxito.");
    }

    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("✗ No hay artículos cargados.");
        } else {
            System.out.println("\n*** Lista de Artículos ***");
            for (Articulo articulo : lista) {
                articulo.mostrar();
            }
        }
    }

    public static void modificarArticulo() {
        System.out.print("► Ingrese el ID del artículo a modificar: ");
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        for (Articulo a : lista) {
            if (a.id == id) {
                System.out.print("► Nuevo nombre: ");
                a.nombre = sc.nextLine();

                System.out.print("► Nueva descripción: ");
                a.descripcion = sc.nextLine();

                System.out.print("► Nuevo precio: ");
                a.precio = sc.nextDouble();
                sc.nextLine(); // limpiar buffer

                System.out.println("✓ Artículo actualizado correctamente.");
                return;
            }
        }
        System.out.println("✗ Artículo no encontrado.");
    }

    public static void eliminarArticulo() {
        System.out.print("► Ingrese el ID del artículo a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        boolean eliminado = lista.removeIf(a -> a.id == id);

        if (eliminado) {
            System.out.println("✓ Artículo eliminado.");
        } else {
            System.out.println("✗ Artículo no encontrado.");
        }
    }
}
