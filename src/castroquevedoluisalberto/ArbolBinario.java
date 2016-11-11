
package castroquevedoluisalberto;

/**
 *
 * @author Usersone
 */
public class ArbolBinario<T extends Comparable<T>>
{
    private NodoA<T> raiz;
    
    public ArbolBinario(){
     raiz=null;
    }
    public boolean vacio(){
     return raiz==null;
    }
    public void agregar(T dato){
     NodoA<T> nuevo=new NodoA<T>(dato);
     if(vacio())
         raiz=nuevo;  
     else{
         NodoA<T> aux= raiz;
         NodoA<T> padre;
         
         while(true){
            padre=aux;  
            if(dato==aux.getDato()){
              System.out.println("Este numero lo ingreso recientemente, ingrese uno distinto!");
             break;     
            }
            if(dato.compareTo(aux.getDato())==-1){
             aux=aux.getNodoIzquierdo();
             if(aux==null){
              padre.setNodoIzquierdo(nuevo);
              return;
              }
            }
            else if(dato.compareTo(aux.getDato())==1){
             aux=aux.getNodoDerecho();
             if(aux==null){
              padre.setNodoDerecho(nuevo);
              return;
              }
            }
          }
        }
    }
    public void Buscar(T dato){
        NodoA<T> aux= raiz;
      try{
        while(aux.getDato()!=dato){
         if(dato.compareTo(aux.getDato())==-1)
          aux=aux.getNodoIzquierdo();
          else
           aux=aux.getNodoDerecho();
          if(aux==null){
             System.out.println("El dato no existe!");}
        }
       System.out.println("El dato buscado es "+aux.getDato());
    }catch(NullPointerException y){
     System.out.println("porfavor elija otro numero");
    }
      /*/if(raiz==null)
       System.out.println("no existe!");
      if(raiz.getDato()==dato)
        System.out.println("El dato buscado es: "+ raiz.getDato());
      if(raiz.getDato()>dato)
        Buscar(dato,raiz.getIzq());
       else
        Buscar(dato,raiz.getDer());*/
    }
    public void inorden(){
     System.out.println("Recorrido Inorden\n");   
     otroinorden(raiz);
    }
    private void otroinorden(NodoA<T> raiz){
      if(raiz!=null){
       otroinorden(raiz.getNodoIzquierdo());
       System.out.println(raiz.getDato()+"");
       otroinorden(raiz.getNodoDerecho());
      }
    
    }
    /*public void encontrar(){
       Nododerecho(raiz);
    }
    //int conta=0;
    /*private void Nododerecho(NodoArbol raiz){
     NodoArbol n=raiz;
     
     if(n.getIzq()!=null&&conta<1){
        conta++;
        n=n.getIzq(); 
        }
     if(n.getDer()!=null){
        n=n.getDer();
         Nododerecho(n);
        }
      else{
        System.out.println("El nodo es "+n.getDato());
        
        }
     
    }*/
}
