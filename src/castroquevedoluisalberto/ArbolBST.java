/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castroquevedoluisalberto;

/**
 *
 * @author Usersone
 * @param <T>
 */
public class ArbolBST<T extends Comparable<T>> {

    private NodoA<T> raiz;

    public ArbolBST() {
        raiz = null;
    }

    public boolean vacio() {
        return raiz == null;
    }

    public void agregar(Integer dato) {
        @SuppressWarnings("Convert2Diamond")
        NodoA<T> nuevo = new NodoA<T>((T) dato);
        if (vacio()) {
            raiz = nuevo;
        } else {
            NodoA<T> aux = raiz;
            NodoA<T> padre;

            while (true) {
                padre = aux;
                if (dato == aux.getDato()) {
                    System.out.println("Este numero lo ingreso recientemente, ingrese uno distinto!");
                    break;
                } else {
                    if (dato.compareTo((Integer) aux.getDato()) < 0) {
                        if (raiz.dato.compareTo(aux.getDato()) == -1) {
                        } else {
                            aux = aux.getNodoDerecho();
                            if (aux == null) {
                                padre.setNodoDerecho(nuevo);
                                return;
                            }
                        }
                    } else {
                        aux = aux.getNodoIzquierdo();
                        if (aux == null) {
                            padre.setNodoIzquierdo(nuevo);
                            return;
                        }
                    }
                }
            }//termina while
        }
    }

    @SuppressWarnings("UnusedAssignment")
    public void eliminar(NodoA<T> nodo, T dato) {
        NodoA<T> aux, otro;
        if (nodo != null) {
            if (dato.compareTo(nodo.getDato()) < 0) {
                // Antes de avanzar, 
                eliminar(nodo.getNodoIzquierdo(), dato);
            } else {
                if (dato.compareTo(nodo.getDato()) > 0) {
                    eliminar(nodo.getNodoDerecho(), dato);
                } else { // El dato ya se encontró
                    otro = nodo;
                    //otro.setDato(dato);
                    otro.setNodoDerecho(nodo);
                    otro.setNodoIzquierdo(nodo);
                    if (otro.getNodoDerecho() == null) {
                        nodo = otro.getNodoIzquierdo();
                    } else {
                        if (otro.getNodoIzquierdo() == null) {
                            nodo = otro.getNodoDerecho();
                        } else {
                            aux = otro.getNodoIzquierdo();
                            while (aux.getNodoDerecho() != null) {
                                aux = aux.getNodoDerecho();
                            }
                            otro.setDato(aux.getDato());
                            otro = aux;
                            aux = aux.getNodoIzquierdo();
                            otro = null;
                        }
                    }
                }
            }
        } else {
            System.out.println("El nodo no se encuentra en el árbol.");
        }
    }

    public NodoA<T> buscarMCA(ArbolBST arbol, T v1, T v2) {
        NodoA<T> auxiliar = raiz;

        if (v1.compareTo(auxiliar.getDato()) == -1) {
            while (auxiliar.dato != v1) {
                if (v1.compareTo(auxiliar.getDato()) == -1 || v1.compareTo(auxiliar.getDato()) == 1) {
                    auxiliar = auxiliar.getNodoIzquierdo();
                    System.out.println(auxiliar.getNodoIzquierdo().getDato());
                } 
                else {
                    auxiliar = auxiliar.getNodoDerecho();
                    System.out.println(auxiliar.getNodoDerecho().getDato());
                }
                if (auxiliar == null) {
                    return null;
                }
            }

            System.out.println(auxiliar.getNodoIzquierdo());
            return auxiliar.getNodoIzquierdo();
        } 
        else {
            while (auxiliar.dato != v1) {
                if (v2.compareTo(auxiliar.getNodoDerecho().getDato()) == 1) {
                    auxiliar = auxiliar.getNodoIzquierdo();
                    System.out.println(auxiliar.getNodoIzquierdo().getDato());
                } else {
                    auxiliar = auxiliar.getNodoDerecho();
                    System.out.println(auxiliar.getNodoDerecho().getDato());
                }
                if (auxiliar == null) {
                    return null;
                }
                return auxiliar.getNodoDerecho();
            }
            return auxiliar;
        }

    }

    public void buscar(NodoA<T> raiz, T dato) {
        if (raiz != null) {
            if (dato.compareTo(raiz.getDato()) < 0) { // Vamos por la izquierda
                buscar(raiz.getNodoIzquierdo(), dato);
            } else if (dato.compareTo(raiz.getDato()) > 0) { // Vamos por la derecha
                buscar(raiz.getNodoDerecho(), dato);
            } else {
                System.out.println("El objeto se encontró el en arbol.");
            }
        } else {
            System.out.println("No se encontró el objeto");
        }
    }

    private void _insertar(NodoA<T> nodo, T dato) {
        if (dato.compareTo(nodo.getDato()) < 0) {
            if (nodo.getNodoIzquierdo() == null) {
                nodo.setNodoIzquierdo(new NodoA(dato));
            } else {
                _insertar(nodo.getNodoIzquierdo(), dato);
            }
        } else {
            if (dato.compareTo(nodo.getDato()) > 0) {
                if (nodo.getNodoDerecho() == null) {
                    nodo.setNodoDerecho(new NodoA(dato));
                } else {
                    _insertar(nodo.getNodoDerecho(), dato);
                }
            }
        }
    }

    // @Override
    @SuppressWarnings("Convert2Diamond")
    public Integer insertar(T dato) {
        if (raiz == null) {
            raiz = new NodoA<T>(dato);
        } else {
            _insertar(raiz, dato);
        }
        return 0;
    }

    public void eliminaNodo(NodoA<T> nodo, Integer direccion) {
        NodoA<T> otro, aux, aux1;
        if (direccion == -1) {
            otro = nodo.getNodoIzquierdo();
        } else {
            otro = nodo.getNodoDerecho();
        }
        if (otro.getNodoDerecho() == null) {
            if (direccion == -1) {
                nodo.setNodoIzquierdo(otro.getNodoIzquierdo());
            } else {
                nodo.setNodoDerecho(otro.getNodoIzquierdo());
            }

        } else {
            if (otro.getNodoIzquierdo() == null) {
                if (direccion == -1) {
                    nodo.setNodoIzquierdo(otro.getNodoDerecho());
                } else {
                    nodo.setNodoDerecho(otro.getNodoDerecho());
                }
            } else {
                aux = otro.getNodoIzquierdo();
                aux1 = aux;
                while (aux.getNodoDerecho() != null) {
                    aux1 = aux;
                    aux = aux.getNodoDerecho();
                }
                otro.setDato(aux.getDato());
                if (aux == aux1) {
                    otro.setNodoIzquierdo(null);
                } else {
                    aux1.setNodoDerecho(null);
                }
            }
        }
    }

    public void eliminarR(NodoA<T> nodo, T dato) {
        NodoA<T> aux, otro;
        if (dato.compareTo(nodo.getDato()) < 0) {
            if (nodo.getNodoIzquierdo() != null) {
                if (dato.compareTo(nodo.getNodoIzquierdo().getDato()) == 0) {
                    // Este es el nodo
                    eliminaNodo(nodo, -1);

                } else {
                    eliminar(nodo.getNodoIzquierdo(), dato);
                }
            }

        } else {
            if (dato.compareTo(nodo.getDato()) > 0) {
                if (nodo.getNodoDerecho() != null) {
                    if (dato.compareTo(nodo.getNodoDerecho().getDato()) == 0) {
                        // Este es el nodo
                        eliminaNodo(nodo, 1);

                    } else {
                        eliminar(nodo.getNodoDerecho(), dato);
                    }
                }

            }
        }
    }
}
