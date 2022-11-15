public class ArbolG {
    public class NodoArbol{
        String data;
        NodoArbol son;
        NodoArbol brother;

        public NodoArbol(String tdata, NodoArbol tson, NodoArbol tbro) {
            data = tdata;
            son = tson;
            brother = tbro;
        }
    }
    private NodoArbol root;

    public ArbolG() {
        this.root = null;
    }

    public void Insertar(){

    }

}
