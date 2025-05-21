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
        System.out.print("► Ingrese el nombre del artículo: ");//solo usamos los iconitos si tenemos UTF-8
        String nombre = sc.nextLine();

                if (nombre.isEmpty()) {
            System.out.println("✗ El nombre del artículo no puede estar vacío. \nVuelve al menú");
            return;
                }
        System.out.print("► Ingrese la descripción del artículo: ");//solo usamos los iconitos si tenemos UTF-8
        String descripcion = sc.nextLine();

           if (descripcion.isEmpty()) {
            System.out.println("✗ La descripción del artículo no puede estar vacía.\nVuelve al menú");
            return;
        }

        System.out.print("► Ingrese el precio del artículo (usar punto para decimales): ");//solo usamos los iconitos si tenemos UTF-8
        double precio = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        Articulo nuevo = new Articulo(nombre, descripcion, precio);
        lista.add(nuevo);
        System.out.println("✓ Artículo agregado con éxito.");//solo usamos los iconitos si tenemos UTF-8
    }

    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("✗ No hay artículos cargados.");//solo usamos los iconitos si tenemos UTF-8
        } else {
            System.out.println("\n*** Lista de Artículos ***");
            for (Articulo articulo : lista) {
                articulo.mostrar();
            }
        }
    }

    public static void modificarArticulo() {
        System.out.print("► Ingrese el ID del artículo a modificar: ");//solo usamos los iconitos si tenemos UTF-8
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        for (Articulo a : lista) {
            if (a.id == id) {
                System.out.print("► Nuevo nombre: ");
                a.nombre = sc.nextLine();

                System.out.print("► Nueva descripción: ");//solo usamos los iconitos si tenemos UTF-8
                a.descripcion = sc.nextLine();

                System.out.print("► Nuevo precio: ");//solo usamos los iconitos si tenemos UTF-8
                a.precio = sc.nextDouble();
                sc.nextLine(); // limpiar buffer

                System.out.println("✓ Artículo actualizado correctamente.");//solo usamos los iconitos si tenemos UTF-8
                return;
            }
        }
        System.out.println("✗ Artículo no encontrado.\nvolvemos al inicio");//solo usamos los iconitos si tenemos UTF-8
    }

    public static void eliminarArticulo() {
        System.out.print("► Ingrese el ID del artículo a eliminar: ");//solo usamos los iconitos si tenemos UTF-8
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        boolean eliminado = lista.removeIf(a -> a.id == id);

        if (eliminado) {
            System.out.println("✓ Artículo eliminado.");//solo usamos los iconitos si tenemos UTF-8
        } else {
            System.out.println("✗ Artículo no encontrado.");//solo usamos los iconitos si tenemos UTF-8
        }
    }
}
