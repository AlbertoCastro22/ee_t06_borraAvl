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
public class Burbuja{
    public static Integer[] burbuja1(Integer miarreglo[]){
        int intercambios=0,comparaciones=0;
        int aux=0;
        for(int i=1;i<miarreglo.length;i++){
            for(int j=miarreglo.length-1;j>=i;j--){
                comparaciones++;
                if(miarreglo[j-1]>miarreglo[j]){
                    intercambios++;
                    aux=miarreglo[j-1];
                miarreglo[j-1]=miarreglo[i];
                miarreglo[j]=aux;
                }
            }
        }
        System.out.println("Numero de intercambios: "+intercambios);
        System.out.println("Numero de comparaciones: "+comparaciones);
        return miarreglo;
    }
    public static Integer[] burbujaConSenial(Integer miarreglo[]){
    int aux=0,i=0;
     boolean ban=false;
    while(i<miarreglo.length-1&&ban==false){
       ban=true;
       for(int j=i;j<miarreglo.length-1;j++){
           if(miarreglo[j]<miarreglo[j+1]){
               aux=miarreglo[j];
               miarreglo[j]=miarreglo[j+1];
               miarreglo[j+1]=aux;
               ban=false;
           }
       }
    }
    i++;
        return miarreglo;
    }
}
