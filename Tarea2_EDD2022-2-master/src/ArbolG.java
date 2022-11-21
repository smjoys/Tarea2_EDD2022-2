import java.util.StringTokenizer;
import java.util.*;


class ArbolG {
    private NodoArbol root;


    //Contructor ArbolG
    public ArbolG(){
        root=null;
    }


    ///////////////////////////////////////////////////////////////////3) NewNode
    public boolean AgregarNodo(String elPath,String elDato) {
        if (root == null) {
            root = new NodoArbol(elDato, null, null);
            return true;
        } else {
            NodoArbol tmp = buscaNodo(elPath);
            if (tmp == null) {
                return false;
            } else {
                return AgregaHermano(tmp, elDato);
            }
        }
    }

    private boolean AgregaHermano(NodoArbol elPadre, String elDato){
        NodoArbol tmp=elPadre.hijo;
        if(tmp == null){
            elPadre.hijo=new NodoArbol(elDato,null,null);
            return true;
        } else {
            elPadre.hijo = new NodoArbol(elDato,null, elPadre.hijo);
            return true;
        }
    }



    ///////////////////////////////////////////////////////////// 1) Calcular Altura

    public int CalcularAltura(){
        return CalcularAltura(root,0);
    }





    private int CalcularAltura(NodoArbol nodo,int alt){
        if(nodo==null){
            return 0;
        }else{
            int alturaDer=CalcularAltura(nodo.hijo,alt);
            int alturaIzq = CalcularAltura(nodo.hermano,alt);

            if (alturaIzq > alturaDer) {
                return (alturaIzq+1 );
            }
            else {
                return (alturaDer+1 );
            }


        }

    }

    ///////////////////////////////////////////////////////////////// 2) Peso

    public int Peso() {
        if(root==null){
            return 0;
        }else{
            return Peso(root,0)-1;
        }
    }

    private int Peso(NodoArbol nod,int peso) {
        if (nod == null) {
            peso++;
            return peso;
        }
        return (Peso(nod.hermano,peso)+ Peso(nod.hijo,peso));
    }


    ///////////////////////////////////////////////////////////////// 3) Peso













    ////////////////////////////////////////////////////////////////// PreOrdenInterativo

    public void PreOrdenIterativo(){

        }




    //////////////////////////////////////////////////////////Metodos de ayuda
    private NodoArbol buscaNodo(String elPath)
    {
        NodoArbol tmp1= root;
        NodoArbol tmp2 = tmp1;
        StringTokenizer path = new StringTokenizer(elPath,"/");
        String s;
        while(path.hasMoreTokens())
        { s = path.nextToken();
            while(tmp1 !=null)
            {
                if(s.equalsIgnoreCase(tmp1.nombre))  break;
                else {tmp2 = tmp1= tmp1.hermano;}
            }
            if(tmp1 == null) return tmp1;
            else {tmp2 = tmp1;tmp1 = tmp1.hijo;}
        }
        return tmp2;
    }




    public void Imprimir() {
        imprime(root, " ");
    }

    private void imprime(NodoArbol r, String tab) {
        if (r!=null) {
            System.out.println(tab + r.nombre);
            imprime(r.hijo, tab +"  ");
            imprime(r.hermano,tab);
        }
    }









}


