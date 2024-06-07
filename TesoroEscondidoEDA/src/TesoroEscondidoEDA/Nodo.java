package TesoroEscondidoEDA;

public class Nodo {
    public Nodo derecha;
    public Nodo izquierda;
    public int llave;
    public Object contenido;

    public Nodo(int indice) {
        llave = indice;
        derecha = null;
        izquierda = null;
        contenido = null;
    }
}
