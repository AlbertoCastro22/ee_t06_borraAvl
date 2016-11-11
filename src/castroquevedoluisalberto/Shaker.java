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
import java.util.*;
public class Shaker {
    public static Integer[] shaker(Integer []arreglo){
            int i,izquierda,derecha,k,aux;
            int intercambios=0,comparaciones=0;
            izquierda=1;
            derecha=arreglo.length-1;
            k=arreglo.length-1;
            while(izquierda<=derecha){
                for( i=derecha;i>=izquierda;i--){
                    comparaciones++;
                    if(arreglo[i-1]>arreglo[i]){
                        intercambios++;
                        aux=arreglo[i-1];
                        arreglo[i-1]=arreglo[i];
                        arreglo[i]=aux;
                        k=i;
                        
                    }//termino del if
               
               }//termino del for
                izquierda=k+1;
               for(i=izquierda;i<=derecha;i++){
                   comparaciones++;
                   if(arreglo[i-1]>arreglo[i]){
                       intercambios++;
                       aux=arreglo[i-1];
                       arreglo[i-1]=arreglo[i];
                       arreglo[i]=aux;
                       k=i;
                   }//termina el segundo if
              
                }//termina el segundo for
               derecha=k-1;
            }//termina el while
            System.out.println("Numero de intercambios: "+intercambios);
             System.out.println("Numero de comparaciones: "+comparaciones);
        return arreglo;
    }
}
