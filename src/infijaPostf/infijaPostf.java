package infijaPostf;

import java.util.Scanner;

public class infijaPostf {
    public static void main(String[] args) {
        String expresion, expreForma;
        String exPosFija = "";


        Pila pilita = new Pila();

        Scanner sc = new Scanner(System.in);
        System.out.println("Dame la expresion infija a convertir a postfija: ");
        expresion = sc.nextLine();

        expreForma = pilita.eliminarEspacios(expresion);

        char[] arrExpresion = expreForma.toCharArray();

        for (int i = 0; i < arrExpresion.length; i++) {
            switch (arrExpresion[i]) {
                case '+':
                case '-':
                    if (pilita.estaVacia()) {
                        pilita.empujar(arrExpresion[i]);
                    } else if (!pilita.estaVacia() && (pilita.cima() == '^' || pilita.cima() == '*' || pilita.cima() == '/')) {
                        char a;
                        while (!pilita.estaVacia()) {
                            a = pilita.sacar();
                            exPosFija = pilita.agregarPostFija(a, exPosFija);
                        }
                        pilita.empujar(arrExpresion[i]);
                    } else if (!pilita.estaVacia() && (pilita.cima() == '+' || pilita.cima() == '-')) {
                        char a;
                        a = pilita.sacar();
                        exPosFija = pilita.agregarPostFija(a, exPosFija);
                        pilita.empujar(arrExpresion[i]);
                    } else if (pilita.cima() == '(') {
                        pilita.empujar(arrExpresion[i]);
                    }


                    break;
                case '*':
                case '/':

                    if (pilita.estaVacia()) {
                        pilita.empujar(arrExpresion[i]);
                    } else if (!pilita.estaVacia() && (pilita.cima() == '^')) {
                        char a;
                        while (!pilita.estaVacia()) {
                            a = pilita.sacar();
                            exPosFija = pilita.agregarPostFija(a, exPosFija);
                        }
                        pilita.empujar(arrExpresion[i]);
                    } else if (!pilita.estaVacia() && (pilita.cima() == '+' || pilita.cima() == '-')) {

                        pilita.empujar(arrExpresion[i]);
                    } else if (!pilita.estaVacia() && (pilita.cima() == '*' || pilita.cima() == '/')) {
                        char a;
                        a = pilita.sacar();
                        exPosFija = pilita.agregarPostFija(a, exPosFija);
                        pilita.empujar(arrExpresion[i]);
                    } else if (pilita.cima() == '(') {
                        pilita.empujar(arrExpresion[i]);
                    }

                    break;
                case '(':
                    pilita.empujar(arrExpresion[i]);
                    break;
                case ')':
                    while (!pilita.estaVacia() && (pilita.cima() == '/' || pilita.cima() == '^' || pilita.cima() == '+' || pilita.cima() == '-')) {
                        while (!pilita.estaVacia()) {
                            char a;
                            a = pilita.sacar();
                            if (a != '(') {
                                exPosFija = pilita.agregarPostFija(a, exPosFija);
                            }

                        }

                    }

                    break;
                default:
                    exPosFija = pilita.agregarPostFija(arrExpresion[i], exPosFija);
                    break;
            }
        }

        char a;
        while (!pilita.estaVacia()) {
            a = pilita.sacar();
            exPosFija = pilita.agregarPostFija(a, exPosFija);
        }
        System.out.println(exPosFija);
    }
}
