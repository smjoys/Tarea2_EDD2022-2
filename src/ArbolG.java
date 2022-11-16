import java.util.StringTokenizer;

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

    public int altura(){
        return altura(root);
    }
    private int altura(NodoArbol n){
        if (n == null) {
            return 0;
        } else return 1 + altura(n.son);

    }

    public void preordenIterativo(NodoArbol n){
        System.out.println(n.data);
        preordenIterativo(n.son);
        preordenIterativo(n.brother);
    }
    public string Path(String o){

    }
    public void newNode(Path p, String n){

    }

}
