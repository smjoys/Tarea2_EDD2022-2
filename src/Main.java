public class Main {
    public static void main(String[] args) {

        ArbolG arbol= new ArbolG();


        arbol.AgregarNodo("","a");
        arbol.AgregarNodo("a","c");
        arbol.AgregarNodo("a","b");

        arbol.AgregarNodo("a/c","k");
        arbol.AgregarNodo("a/c","j");
        arbol.AgregarNodo("a/b","h");
        arbol.AgregarNodo("a/b","e");


        arbol.AgregarNodo("a/b/h","m");
        arbol.AgregarNodo("a/b/h","l");
        arbol.AgregarNodo("a/b/h/l","t");

        arbol.Imprimir();
        System.out.println("////////////////////////////////////////////////////");

        System.out.println("La altura del arbol es: " +arbol.CalcularAltura());
        System.out.println("El peso del arbol es: " + arbol.Peso());
        arbol.PreOrdenIterativo();
        System.out.println(arbol.Path("m"));

    }
}