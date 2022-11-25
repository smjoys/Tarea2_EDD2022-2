public class NodoArbol {
    //Atributos de la Clase NodoArbol
    String nombre;
    NodoArbol hijo;
    NodoArbol hermano;

    //Constructor de la Clase NodoArbol
    NodoArbol(String name,NodoArbol son, NodoArbol brother) {
        nombre = name;
        hijo=son;
        hermano=brother;
    }
}

