
import java.util.StringTokenizer;
import java.util.*;


    class ArbolG {
        private NodoArbol root;


        //Contructor ArbolG
        public ArbolG(){
            root=null;
        }







        ///////////////////////////////////////////////////////////// 1) Calcular Altura

        public int CalcularAltura(){
            if(root==null){
                return 0;
            }else{
                return CalcularAltura(root);
            }
        }


            public int CalcularAltura(NodoArbol nodo){
                if(nodo !=null){
                    return Math.max(CalcularAltura(nodo.hijo), CalcularAltura(nodo.hermano));
                }
                return 0;
            }







        ///////////////////////////////////////////////////////////////// 2) Peso

        int Peso() {
            return Peso(root);
        }

        private int Peso(NodoArbol nodo) {
            if (nodo ==null){
                return 0;
            } else{
                return 1 + (Peso(nodo.hijo) +Peso(nodo.hermano));
            }
        }



        ///////////////////////////////////////////////////////////////// 3)String Path


        public String Path(String nombre){
            return BuscarNodo2(nombre,root);

        }

        private String BuscarNodo2(String nombre, NodoArbol nodo){
            String s=nodo.nombre+"/";
            if(nodo.nombre.equalsIgnoreCase(nombre)) {
                return s += nodo.nombre;
            }

                if (nodo.hijo != null) {
                     s+=BuscarNodo2(nombre, nodo.hijo) ;
                }

                if (nodo.hermano != null) {
                    s+=BuscarNodo2(nombre, nodo.hermano);
                }

                return s;
        }



        ///////////////////////////////////////////////////////////////////4) NewNode
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

        /////////////////////////////////////////////////////////////////5)Delete




        public void Delete(String elPath) {
            if(root==null){
                System.out.println("El arbol esta vacio");
            }else{
                NodoArbol nodo=buscaNodo(elPath);
                if(nodo==null){
                    System.out.println("Error");
                }else{
                    Borrar(nodo);
                }
            }
        }

        private void Borrar(NodoArbol nodo){
            NodoArbol auxIzq= nodo.hijo;
            NodoArbol auxDer=nodo.hermano;

            if(auxDer==null && auxIzq==null){
                if(root==nodo){
                    root=null;
                }else{

                }
            }

        }





        //////////////////////////////////////////////////////////////////6) PreOrdenInterativo

        public void PreOrdenIterativo(){

        }

        /////////////////////////////////////////////////////////////////7) Por Nivel

        public void PorNivel(){
            Fila f= new Fila();



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


        int Size() {
            return size(root);
        }

        private int size(NodoArbol n){
            if (n ==null){
                return 0;
            } else{
                return 1 + (size(n.hijo) + size(n.hermano));
            }
        }





    }

