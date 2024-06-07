package TesoroEscondidoEDA;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Insertar algunos nodos en el árbol por defecto
        arbol.insertar(30, "Yerba");
        arbol.insertar(20, "Azucar");
        arbol.insertar(40, "Arroz");
        arbol.insertar(25, "Manteca");
        arbol.insertar(35, "Harina");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Recorrer el arbol e imprimir los nodos");
            System.out.println("2. Buscar el precio mas cercano a un valor objetivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Recorrido del arbol:");
                    arbol.recorrer(arbol.raiz);
                    break;
                case 2:
                    System.out.print("Ingrese el precio objetivo: ");
                    int precioObjetivo = scanner.nextInt();
                    Nodo nodoMasCercano = Arbol.encontrarPrecioMasCercano(arbol, precioObjetivo);

                    if (nodoMasCercano != null) {
                        System.out.println("\nEl producto con precio mas cercano a " + precioObjetivo + " es: " + nodoMasCercano.contenido + " con el precio de " + nodoMasCercano.llave);
                        Arbol.mostrarCaminoRecorrido(arbol.raiz, nodoMasCercano, precioObjetivo);
                    } else {
                        System.out.println("No se encontro ningun producto en el arbol.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}