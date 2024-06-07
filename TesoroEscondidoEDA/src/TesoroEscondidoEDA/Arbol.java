package TesoroEscondidoEDA;

public class Arbol {
    
    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(int i, Object producto) {
        Nodo n = new Nodo(i);
        n.contenido = producto;

        if (raiz == null) {
            raiz = n;
        } else {
            Nodo aux = raiz;
            Nodo padre = null; // Variable auxiliar para seguir el nodo padre

            while (aux != null) {
                padre = aux;
                if (n.llave >= aux.llave) {
                    aux = aux.derecha;
                } else {
                    aux = aux.izquierda;
                }
            }

            if (n.llave < padre.llave) {
                padre.izquierda = n;
            } else {
                padre.derecha = n;
            }
        }
    }

    public void recorrer(Nodo n) {
        if (n != null) {
            recorrer(n.izquierda);
            System.out.println("Indice " + n.llave + " Productos " + n.contenido);
            recorrer(n.derecha);
        }
    }

    public static Nodo encontrarPrecioMasCercano(Arbol arbol, int precio) {
        Nodo nodoActual = arbol.raiz;
        Nodo nodoMasCercano = null;
        int diferenciaMinima = Integer.MAX_VALUE;

        while (nodoActual != null) {
            int diferencia = Math.abs(nodoActual.llave - precio);
            if (diferencia < diferenciaMinima) {
                diferenciaMinima = diferencia;
                nodoMasCercano = nodoActual;
            }
            if (nodoActual.llave > precio) {
                nodoActual = nodoActual.derecha;
            } else {
                nodoActual = nodoActual.izquierda;
            }
        }
        return nodoMasCercano;
    }

    public static void mostrarCaminoRecorrido(Nodo nodoActual, Nodo nodoMasCercano, int precioObjetivo) {
        if (nodoActual == null) {
            return;
        }
        if (nodoActual == nodoMasCercano) {
            System.out.println("Camino recorrido para encontrar el precio " + precioObjetivo + ":");
        }
        System.out.print(nodoActual.llave + " ");
        if (nodoActual.llave < precioObjetivo) {
            mostrarCaminoRecorrido(nodoActual.derecha, nodoMasCercano, precioObjetivo);
        } else {
            mostrarCaminoRecorrido(nodoActual.izquierda, nodoMasCercano, precioObjetivo);
        }
    }
}
