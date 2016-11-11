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
public class ArbolAVL<T extends Comparable<T>> {
    NodoA<T> raiz;
    
    public NodoA<T> getRaizAVL(){
        return (NodoA<T>) raiz;
    }
    
    public NodoA castAVL(NodoA nodo){
        return (NodoA) nodo;
    }
    
    public void revisarI(NodoA<T> nodo, Integer direccion){
        NodoA<T> nodo1, nodo2, nodo3;
        if (direccion ==-1){
          nodo1=(NodoA<T>) nodo.getNodoIzquierdo();
          nodo2=(NodoA<T>) nodo1.getNodoIzquierdo();
        }else{
          nodo1=(NodoA<T>) nodo.getNodoDerecho();
          nodo2=(NodoA<T>) nodo1.getNodoIzquierdo();    
        }
        if(nodo2.getFe() == -1){// Rotacion II
            nodo1.setNodoIzquierdo(nodo2.getNodoDerecho());
            nodo2.setNodoDerecho(nodo1);
            nodo1.setFe(0);
            if (direccion == -1){
                nodo.setNodoIzquierdo(nodo2);
            }else{
                nodo.setNodoDerecho(nodo2); 
            }
        }else{ // Rotacion ID
            nodo3 = (NodoA<T>) nodo2.getNodoDerecho();
            nodo1.setNodoIzquierdo(nodo3.getNodoDerecho());
            nodo3.setNodoDerecho(nodo1);
            nodo2.setNodoDerecho(nodo3.getNodoIzquierdo());
            nodo3.setNodoIzquierdo(nodo2);
            if(nodo3.getFe() == -1){
                nodo1.setFe(1);
            }else{
                nodo1.setFe(0);
            }
            if (nodo3.getFe() == 1){
                nodo2.setFe(-1);
            }else{
                nodo2.setFe(0);
            }
            if (direccion == -1){
                nodo.setNodoIzquierdo(nodo3);
            }else{
                nodo.setNodoDerecho(nodo3); 
            }
            
        }
        nodo1.setFe(0);
    }
    
    public void revisarD(NodoA<T> nodo, Integer direccion){
        NodoA<T> nodo1, nodo2, nodo3;
        if (direccion ==-1){
            nodo1=(NodoA) nodo.getNodoIzquierdo();
            nodo2=(NodoA) nodo1.getNodoDerecho();
        }else{
            nodo1=(NodoA) nodo.getNodoDerecho();
            nodo2=(NodoA) nodo1.getNodoDerecho();
        }
        if(nodo2.getFe() == 1){// Rotacion DD
            nodo1.setNodoDerecho(nodo2.getNodoIzquierdo());
            nodo2.setNodoIzquierdo(nodo1);
            nodo1.setFe(0);
            if (direccion == -1){
                nodo.setNodoIzquierdo(nodo2);
            }else{
                nodo.setNodoDerecho(nodo2); 
            }
            
            
        }else{ // Rotacion DI
            nodo3 = (NodoA<T>) nodo2.getNodoIzquierdo();
            nodo1.setNodoDerecho(nodo3.getNodoIzquierdo());
            nodo3.setNodoIzquierdo(nodo1);
            nodo2.setNodoIzquierdo(nodo3.getNodoDerecho());
            nodo3.setNodoDerecho(nodo2);
            if(nodo3.getFe() == 1){
                nodo1.setFe(-1);
            }else{
                nodo1.setFe(0);
            }
            if (nodo3.getFe() == -1){
                nodo2.setFe(1);
            }else{
                nodo2.setFe(0);
            }
            if (direccion == -1){
                nodo.setNodoIzquierdo(nodo3);
            }else{
                nodo.setNodoDerecho(nodo3); 
            }
            
        }
        nodo1.setFe(0);
    }
    
    private Integer _insertar(NodoA<T> nodo, T dato){
        Integer resultado = 0;
        if (dato.compareTo(nodo.getDato()) < 0){
            if (nodo.getNodoIzquierdo() == null){
                nodo.setNodoIzquierdo(new NodoA(dato));
                switch (castAVL(nodo).getFe()){
                case 1: // El arbol se balanceÃ³
                    castAVL(nodo).setFe(0);
                    resultado = 0;
                    break;
                case 0: // Se cargÃ³ del lado izquierdo
                    castAVL(nodo).setFe(-1);
                    resultado = 1;
                    break;              
                }
                //resultado = 1;
                
            }else{
                switch (_insertar(nodo.getNodoIzquierdo(),dato)){
                case 1: // Se insrtÃ³ un dato nuevo, revisar.
                    switch (castAVL(nodo).getFe()){
                    case 1: // El arbol se balanceÃ³
                        castAVL(nodo).setFe(0);
                        resultado = 0;
                        break;
                    case 0: // Se cargÃ³ del lado izquierdo
                        castAVL(nodo).setFe(-1);
                        resultado = 1;
                        break;  
                    case -1: // Reestructuracion del arbol
                        //if (nodo == raiz){
                            resultado = -1;
                        //}else{                                     
                        //}
                        break;
                    }
                    break;
                case -1:
                    revisarI(castAVL(nodo),-1);
                    break;
                case -2:
                    revisarD(castAVL(nodo),-1);
                    break;       
                }       
            }
        }
        else{
            if (dato.compareTo(nodo.getDato()) > 0){
                if (nodo.getNodoDerecho() == null){
                    nodo.setNodoDerecho(new NodoA(dato));
                    switch (castAVL(nodo).getFe()){
                    case -1: // El arbol se balanceÃ³
                        castAVL(nodo).setFe(0);
                        resultado = 0;
                        break;
                    case 0: // Se cargÃ³ del lado izquierdo
                        castAVL(nodo).setFe(1);
                        resultado = 1;
                        break;              
                    }
                }
                else{
                    switch (_insertar(nodo.getNodoDerecho(),dato)){
                    case 1: // Se insrtÃ³ un dato nuevo, revisar.
                        switch (castAVL(nodo).getFe()){
                        case -1: // El arbol se balanceÃ³
                            castAVL(nodo).setFe(0);
                            resultado = 0;
                            break;
                        case 0: // Se cargÃ³ del lado der
                            castAVL(nodo).setFe(1);
                            resultado = 1;
                            break;  
                        case 1: // Reestructuracion del arbol
                                resultado = -2;
                            }
                            break;
                    case -1:
                        revisarI(castAVL(nodo),1);
                        break;
                    case -2:
                        revisarD(castAVL(nodo),1);
                    break;                   
                        }                                              
                    }
                }
            }       
        return resultado;    
   }
    
    
    public Integer insertar(T dato) {
        if (raiz == null){
            raiz = new NodoA<T>(dato);
        }else{
            Integer result = _insertar(raiz, dato);
            if (result == -1){
            
                // ReestructuraciÃ³n del arbol
                    NodoA<T> nodo1, nodo2;
                    nodo1=(NodoA) raiz.getNodoIzquierdo();
                    
                    if(nodo1.getFe() == -1){// Rotacion II
                        raiz.setNodoIzquierdo(nodo1.getNodoDerecho());
                        nodo1.setNodoDerecho(raiz);
                        castAVL(raiz).setFe(0);
                        raiz = nodo1;
                    }else{ // Rotacion ID
                        nodo2 = (NodoA<T>) nodo1.getNodoDerecho();
                        raiz.setNodoIzquierdo(nodo2.getNodoDerecho());
                        nodo2.setNodoDerecho(raiz);
                        nodo1.setNodoDerecho(nodo2.getNodoIzquierdo());
                        nodo2.setNodoIzquierdo(nodo1);
                        if(nodo2.getFe() == -1){
                            castAVL(raiz).setFe(1);
                        }else{
                            castAVL(raiz).setFe(0);
                        }
                        if (nodo2.getFe() == 1){
                            nodo1.setFe(-1);
                        }else{
                            nodo1.setFe(0);
                        }
                        raiz = nodo2;
                    }
                    castAVL(raiz).setFe(0);
            
                
                         
            }else if (result == -2){
                // ReestructuraciÃ³n del arbol
                NodoA<T> nodo1, nodo2;
                nodo1=(NodoA) raiz.getNodoDerecho();
                
                if(nodo1.getFe() == 1){// Rotacion DD
                    raiz.setNodoDerecho(nodo1.getNodoIzquierdo());
                    nodo1.setNodoIzquierdo(raiz);
                    castAVL(raiz).setFe(0);
                    raiz = nodo1;
                }else{ // Rotacion DI
                    nodo2 = (NodoA<T>) nodo1.getNodoIzquierdo();
                    raiz.setNodoDerecho(nodo2.getNodoIzquierdo());
                    nodo2.setNodoIzquierdo(raiz);
                    nodo1.setNodoIzquierdo(nodo2.getNodoDerecho());
                    nodo2.setNodoDerecho(nodo1);
                    if(nodo2.getFe() == 1){
                        castAVL(raiz).setFe(-1);
                    }else{
                        castAVL(raiz).setFe(0);
                    }
                    if (nodo2.getFe() == -1){
                        nodo1.setFe(1);
                    }else{
                        nodo1.setFe(0);
                    }
                    raiz = nodo2;
                    
                }
                
                castAVL(raiz).setFe(0);
        
            }
        }
        return 0;
    }

    
}
