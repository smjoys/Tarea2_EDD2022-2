public class Fila {

    private Nodo inicio, end;

    public Fila() {
        inicio = null;
        end = null;
    }


    void Insert(int e) {
        if (end == null || inicio == null) {
            end = inicio = new Nodo(e, null);

        } else {
            end.sig = new Nodo(e, null);
            end = end.sig;
        }
    }

    int Delete(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }else {
            int val = inicio.info;
            inicio = inicio.sig;
            return val;
        }
    }

    private boolean isEmpty(){
        return inicio == null || end == null ;
    }

    public void Mostrar(){
        Nodo aux=inicio;
        while(aux.sig==null){
            System.out.println("[" +aux.info + "]");
            aux=aux.sig;

        }
    }






}