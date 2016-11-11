/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castroquevedoluisalberto;

/**
 *
 * @author Usersone
 */
public class Baraja {
    @SuppressWarnings("empty-statement")
    public static Integer[] baraja(Integer[] arreglo){
    int i,aux,k;
    for(i=1;i<arreglo.length;i++){
        aux=arreglo[i];
        k=i-1;
        while(aux<arreglo[k]&&k>0){
            arreglo[k+1]=arreglo[k];
            k=k-1;
        }
        if(arreglo[k]<=aux){
            arreglo[k+1]=aux;
        }
        else{
            arreglo[k+1]=arreglo[k];
            arreglo[k]=aux;
        }
    }
   return arreglo;
    }
    public static Integer[] BarajaConBusquedaBinaria(Integer []arreglo){
            int i,izquierda,derecha,m,j,aux;
            for(i=1;i<arreglo.length;i++){
                 aux = arreglo[i];
                 izquierda=0;
                 derecha=i-1;
                 while(izquierda<=derecha){
                     m=(derecha+izquierda)/2;
                     if(aux<arreglo[m]){
                         derecha=m-1;
                     }
                     else{
                         izquierda=m+1;
                     }
                 }//fin del primer while
                 j=i-1;
                 while(j>=izquierda){
                     arreglo[j+1]=arreglo[j];
                     j=j-1;
                 }
                 arreglo[izquierda]=aux;
                
            }
        return arreglo;
    }
    
}
