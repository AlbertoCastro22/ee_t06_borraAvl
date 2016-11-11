
package castroquevedoluisalberto;

import java.util.*;



public class CastroQuevedoLuisAlberto {

public static void imprimir(Integer [] arreglo){
    for(int x=0;x<arreglo.length;x++){
        System.out.print(arreglo[x]+" ");
    }
    System.out.println();
}    
   
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
    ArbolBST<Integer> arbol=new ArbolBST<Integer>();
    NodoA<Integer> nodo=new NodoA<Integer>(10);
    nodo.setDato(17);
    nodo.setDato(11);
    nodo.setDato(8);
    nodo.setDato(7);
    nodo.setDato(6);
    nodo.setDato(18);
    nodo.setDato(17);
    nodo.setDato(19);
    System.out.println();
    arbol.buscarMCA(arbol, 17, 6);
          // arbol.eliminar(nodo, 11);
           //nodo.preOrden(nodo.llenado());
           System.out.println(nodo);
         /*  Date inicio=Calendar.getInstance().getTime();
          // System.out.println("_________________________\nOrdenado");
         
           int tam=100000;
          
           Integer[] miArregloOrdenado =new Integer[tam];
           Integer[] miArregloDesordenado =new Integer[tam];
           Integer[] miArregloAleatorio =new Integer[tam];
           for(int x=0;x<tam;x++){
               miArregloOrdenado[x]=x;
           }
            int y=tam;
           for(int x=0;x<tam;x++){
               miArregloDesordenado[x]=y--;
           }
           
           Random rd=new Random();
  for(int x=0;x<tam;x++){
               miArregloAleatorio[x]=rd.nextInt(tam);
             
           }
  
         // imprimir(miArregloOrdenado);
           //imprimir(Burbuja.burbuja1(miArregloOrdenado));
          //imprimir(Burbuja.burbujaConSenial(miArregloOrdenado));
         
          //System.out.println("Tiempo de ejecucion: ");
          //System.out.println(new Date(fin.getTime()-inicio.getTime()));
           // System.out.println("_________________________\nDesordenado");
          
            //imprimir(miArregloDesordenado);
           //imprimir(Burbuja.burbuja1(miArregloDesordenado));
          //imprimir(Burbuja.burbujaConSenial(miArregloDesordenado));
         //  System.out.println("Tiempo de ejecucion: ");
         // System.out.println(new Date(fin.getTime()-inicio.getTime()));
// System.out.println("_________________________\nALEATORIO");          
 
           //imprimir(miArregloAleatorio);
           //imprimir(Burbuja.burbuja1(miArregloAleatorio));
          //imprimir(Burbuja.burbujaConSenial(miArregloAleatorio));
         //  System.out.println("Tiempo de ejecucion: ");
          //System.out.println(new Date(fin.getTime()-inicio.getTime()));
          //System.out.println("\n_________________________\n");     
          //imprimir(Shaker.shaker(miArregloOrdenado));
           //imprimir(Shaker.shaker(miArregloDesordenado));
            //imprimir(Shaker.shaker(miArregloAleatorio));
           // System.out.println("\n_________________________\n"); 
          //  imprimir(Baraja.baraja(miArregloAleatorio));
           //  System.out.println("\n_________________________\n"); 
         // imprimir(Baraja.BarajaConBusquedaBinaria(miArregloDesordenado));
          imprimir(Baraja.BarajaConBusquedaBinaria(miArregloAleatorio));
             Date fin=Calendar.getInstance().getTime();
               System.out.println("Tiempo de ejecucion: ");
          System.out.println(new Date(fin.getTime()-inicio.getTime()));*/
          
    }
    
}
