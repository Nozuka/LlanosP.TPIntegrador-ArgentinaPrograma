package org.example;

import org.example.clases.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenidos al torneo", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
        menu();
    }

    public static void mostrarOpciones() {
        JOptionPane.showMessageDialog(null, "Seleccione una opcion:\n" +
                "1. Crear lista de equipos\n" +
                "2. Cargar los equipos\n" +
                "3. Elegir equipo\n" +
                "4. Crear llave derecha\n" +
                "5. Crear llave izquierda\n" +
                "6. Crear rondas\n" +
                "7. Jugar torneo\n" +
                "8. Mostrar resultado del torneo\n" +
                "0. Salir", "Opciones", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void menu() {
        JOptionPane.showMessageDialog(null, "Bienvenido al Menu\nSelecciona una de las siguientes opciones:", "menu", JOptionPane.INFORMATION_MESSAGE);

        // Se inicializan las variables que se utilizarán durante la ejecución del programa.
        boolean salir = true;
        ArrayList<Equipo> listaDeEquipos = null;
        Jugador jugador = null;
        Llave llaveDerecha = null;
        Llave llaveIzquierda = null;
        Ronda ronda = null;
        String opcion = "";

        do {
            //llamo al proceso de mostrar opciones de mi linea 15
            mostrarOpciones();
            // Se utiliza la función mostrarOpciones() para mostrar las opciones disponibles.
            opcion = JOptionPane.showInputDialog(null, "Ingrese la opcion: ", "Ingreso opcion", JOptionPane.INFORMATION_MESSAGE);
            switch (opcion) {
                case "1":
                    listaDeEquipos = crearListaDeEquipos(listaDeEquipos);
                    break;
                case "2":
                    agregarEquipos(listaDeEquipos);
                    break;
                case "3":
                    jugador = elegirEquipo(listaDeEquipos);
                    break;
                case "4":
                    llaveDerecha = crearLlaveDerecha(listaDeEquipos);
                    break;
                case "5":
                    llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
                    break;
                case "6":
                    ronda = crearRondas();
                    break;
                case "7":
                    jugarTorneo(ronda, llaveIzquierda, llaveDerecha, jugador);
                    break;
                case "8":
                    resultadoDelTorneo(jugador);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo", "Salida", JOptionPane.CLOSED_OPTION);
                    salir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingreso invalido");
            }

        } while (salir);
    }

    public static ArrayList<Equipo> crearListaDeEquipos(ArrayList<Equipo> listaDeEquipos) {
        //si no existe; (si es null), entonces creala. Si existe mostrala(retornala)
        if (listaDeEquipos == null) {
            return new ArrayList<Equipo>();
        } else {
            JOptionPane.showMessageDialog(null, "Ya hay una lista de equipos creada", "aviso", JOptionPane.INFORMATION_MESSAGE);
            return listaDeEquipos;
        }
    }

    public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos) {
        if (!
                listaDeEquipos.isEmpty()) {
            String cargaDeEquipos = JOptionPane.showInputDialog(null, "Quisiera ingresar sus propios equipos? SI|NO", "Carga de equipos",
                    JOptionPane.INFORMATION_MESSAGE);
            if (cargaDeEquipos.equalsIgnoreCase("SI")) {
                listaDeEquipos.clear();
            }
        }
        //mostramos un cuadro de diálogo para preguntar al usuario si quiere cargar los equipos y que me diga SI o NO
        String opcion = "";
        // Si no pone ni SI ni NO , muestro un cuadro de dialogo para pedirle que escriba un valor con el do-while
        do {
            opcion = JOptionPane.showInputDialog(null, "Bienvenido a la carga de equipos \n ¿Desea cargar los equipos manualmente?",
                    "Carga de equipos", JOptionPane.INFORMATION_MESSAGE);
            if (opcion == null || opcion.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor");
            }
        } while (opcion == null || opcion.equals(""));

        //si el usuario selecciona "SI", cargamos los equipos manualmente
        if (opcion.equalsIgnoreCase("si")) {
            cargarEquipoManualmente(listaDeEquipos);
        }
        //si el usuario selecciona "no", cargamos los equipos de abajo
        else {
            listaDeEquipos.add(new Equipo("Belgica"));
            listaDeEquipos.add(new Equipo("Francia"));
            listaDeEquipos.add(new Equipo("Portugal"));
            listaDeEquipos.add(new Equipo("Alemania"));
            listaDeEquipos.add(new Equipo("Brasil"));
            listaDeEquipos.add(new Equipo("Italia"));
            listaDeEquipos.add(new Equipo("Argelia"));
            listaDeEquipos.add(new Equipo("Argentina"));
        }
    }

    public static Jugador elegirEquipo(ArrayList<Equipo> listaDeEquipos) {
        //creo una nueva instancia del objeto jugador
        Jugador jugador1 = new Jugador();
        //llamamos al metodo elegirEquipo() del objeto jugador1, pasandolo como argumento
        jugador1.elegirEquipo(listaDeEquipos);
        return jugador1;
    }

    public static Llave crearLlaveDerecha(ArrayList<Equipo> listaDeEquipos) {
        //crea una llave derecha y la armo utilizando la lista de equipos que se le pasa como objeto
        Llave llaveDerecha = new Llave();
        llaveDerecha.armarLlave(listaDeEquipos, 0);
        return llaveDerecha;
    }

    public static Llave crearLlaveIzquierda(ArrayList<Equipo> listaDeEquipos) {
        // lo mismo que en la llave derecha
        Llave llaveIzquierda = new Llave();
        llaveIzquierda.armarLlave(listaDeEquipos, 4);
        return llaveIzquierda;
    }

    public static Ronda crearRondas() {
        // creo una Ronda (para acceder a los métodos)
        return new Ronda();
    }

    public static void jugarTorneo(Ronda ronda, Llave llaveIzquierda, Llave llaveDerecha, Jugador jugador) {
        // utiliza las llaves de la izquierda y la derecha para armar los cuartos de final,
        // luego llama al método "sumarPuntos" del jugador y repite el proceso para las semifinales y la final.
        ronda.cuartosDeFinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        ronda.semifinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        ronda.finalDelTorneo(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
    }

    public static void resultadoDelTorneo(Jugador jugador1) {
        JOptionPane.showMessageDialog(null, "Tu puntuacion es de " + jugador1.getPuntaje() +
                " puntos por elegir el el equipo: " + jugador1.getEquipoSeleccionado().getNombre(), "Puntaje", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cargarEquipoManualmente(ArrayList<Equipo> listaDeEquipos) {
        String[] equipoManual = new String[8];
        String equipoManualCad = " ";
        int i;
        for (i = 0; i < 8; i++) {
            equipoManualCad = JOptionPane.showInputDialog(null, "Ingrese el equipo n°" + (i + 1) + ".", "Ingreso manual de equipos", JOptionPane.INFORMATION_MESSAGE);
            equipoManual[i] = String.copyValueOf(equipoManualCad.toCharArray());
            listaDeEquipos.add(new Equipo(equipoManual[i]));
        }
    }
}