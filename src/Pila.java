public class Pila {

    Nodo raiz;

    public Pila() {
        raiz=null;
    }


    public void push(int x){
        if(raiz==null){

            Nodo nuevo=new Nodo(x,null);
            raiz=nuevo;

        }else{
            Nodo nuevo= new Nodo(x, raiz);
            raiz=nuevo;
        }
    }


    public int top(){
        if(raiz==null){
            return Integer.MIN_VALUE;
        }else{

            return raiz.info;
        }
    }


    public int pop(){
        if(raiz==null){
            return Integer.MAX_VALUE;
        }else{
            int axu= raiz.info;
            raiz=raiz.sig;

            return axu;

        }

    }


    //Clase Nodo
    private class Nodo{
        int info;
        Nodo sig;

        public Nodo(int info, Nodo sig) {
            this.info = info;
            this.sig = sig;
        }


    }





}