package infijaPostf;

import java.util.List;

public class Pila {
    private NodoPila cima;
    int tama = 0;
    String Lista = "";

    public Pila() {
        cima = null;
        tama = 0;
    }

    //Metodo para saber cuando la pila esta vacia
    public boolean estaVacia() {
        return cima == null;
    }

    //Metodo para push un elemento en la pila
    public void empujar(char elem) {
        NodoPila nuevo = new NodoPila(elem);
        nuevo.siguiente = cima;
        cima = nuevo;
        tama++;
    }

    //Metodo para sacar un elemento en la pila
    public char sacar() {
        char auxiliar = cima.dato;

        cima = cima.siguiente;
        tama--;
        return auxiliar;
    }

    //Metodo para saber quien esta en la cima de pila
    public char cima() {
        return cima.dato;
    }


    //Metodo para vaciar la pila
    public void limpiarPila() {
        while (!estaVacia()) {
            sacar();
        }
    }

    public String agregarPostFija(char caracter, String expresion){
        expresion = expresion + " " +  caracter;
        return  expresion;
    }

    public int tamanioPila() {
        return tama;
    }

    //Metodo para eliminar espacios
    public String eliminarEspacios(String expresion) {
        return expresion.replaceAll("\\s", "");
    }


}
