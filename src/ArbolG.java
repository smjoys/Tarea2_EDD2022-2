
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

        private int CalcularAltura(NodoArbol nodo) {

            int der=1,izq=1;
            if (nodo == null) {
                return 0;
            }else{

                if(nodo.hijo!=null){
                    izq+=CalcularAltura(nodo.hijo);
                }

                if(nodo.hermano!=null){
                    der+=CalcularAltura(nodo.hermano);
                }

                if(izq>der){
                    return izq;
                }else{
                    return der;
                }

            }
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


        public void Delete(String path){
            Delete(buscaNodo(path));
        }


        private void Delete(NodoArbol aux){

        }





        //////////////////////////////////////////////////////////////////6) PreOrdenInterativo

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

