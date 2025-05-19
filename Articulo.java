public class Articulo {
    static int contador = 0;
    int id;
    String nombre;
    String descripcion;
    double precio;

    public Articulo(String nombre, String descripcion, double precio) { 
        // LA PALABRA RESERVADA this hace referencia al objeto actual de la clase que se esta llamando
        // que se esta creando
        // el objeto cuando se crea en memoria, se le asigna una dirección de memoria
        this.id = ++contador;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void mostrar() {
        System.out.println("-------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.printf("Precio: $ %.2f%n", precio);
        System.out.println("-------------------------------");
    }
}
