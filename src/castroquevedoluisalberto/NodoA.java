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
public class NodoA<T extends Comparable<T>> {
    T dato;
    int Fe;

    public int getFe() {
        return Fe;
    }

    public void setFe(int Fe) {
        this.Fe = Fe;
    }
    private NodoA<T> nodoIzquierdo;
    private NodoA<T> nodoDerecho;
    public NodoA(T dato){
        this.dato=dato;
        this.nodoIzquierdo=this.nodoDerecho=null;
    }
    
    public void setDato(T dato){
        this.dato=dato;
    }
    public T getDato(){
    return dato;
    }
     public void setNodoDerecho(NodoA<T> nodoDerecho){
        this.nodoDerecho=nodoDerecho;
    }
    public NodoA<T> getNodoDerecho(){
    return nodoDerecho;
    }
     public void setNodoIzquierdo(NodoA<T> nodoIzquierdo){
        this.nodoIzquierdo=nodoIzquierdo;
    }
    public NodoA<T> getNodoIzquierdo(){
    return nodoIzquierdo;
    }
    public String toString(){
    String s="";
    s+="("+dato+","+nodoIzquierdo+","+nodoDerecho+")";
    return s;
    }
    public void llenado(NodoA<Integer> r){
        Integer respuesta=-1,respuesta2=-1;  
    } 
    public void preOrden(NodoA<String>r){
        if(r!=null){
            System.out.println(r.getDato());
            preOrden(r.getNodoIzquierdo());
            preOrden(r.getNodoDerecho());

        }
    }
}
