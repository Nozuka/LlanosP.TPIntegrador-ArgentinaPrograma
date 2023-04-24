package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Ronda {

    private int nroRonda;
    private int cantEquiposEnRonda;
    private int cantEquiposEnLlave;

    public Ronda() {
    }

    public Ronda(int nroRonda, int cantEquiposEnRonda, int cantEquiposEnLlave) {
        this.nroRonda = nroRonda;
        this.cantEquiposEnRonda = cantEquiposEnRonda;
        this.cantEquiposEnLlave = cantEquiposEnLlave;
    }

    public int getNroRonda() {
        return nroRonda;
    }

    public void setNroRonda(int nroRonda) {
        this.nroRonda = nroRonda;
    }

    public int getCantEquiposEnRonda() {
        return cantEquiposEnRonda;
    }

    public void setCantEquiposEnRonda(int cantEquiposEnRonda) {
        this.cantEquiposEnRonda = cantEquiposEnRonda;
    }

    public int getCantEquiposEnLlave() {
        return cantEquiposEnLlave;
    }

    public void setCantEquiposEnLlave(int cantEquiposEnLlave) {

        this.cantEquiposEnLlave = cantEquiposEnLlave;
    }
    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha){
        //numero de ronda
        this.nroRonda=1;
        //setea la cantidad de equipos en llave como 4
        this.cantEquiposEnLlave=4;
        //"Instancio un objeto de partido para usar su metodo
        Partido partido = new Partido();
        //muestro un msj de bienvenida a los cuartos
        JOptionPane.showMessageDialog(null,"Se jugaran los cuartos de final","Cuartos",JOptionPane.INFORMATION_MESSAGE);

        //simulo los partidos
        for (int i=0; i<cantEquiposEnLlave;i+=2){
            partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(i),llaveIzquierda.getEquiposDeLaLlave().get(i+1));

            partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(i), llaveDerecha.getEquiposDeLaLlave().get(i+1));
        }
        //remuevo los que perdieron
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        //cant actual de equipos por llave
        this.cantEquiposEnLlave=2;
    }
    public void removerEquipos(List<Equipo> equipos){
        int contadorEquiposPorLlave = cantEquiposEnLlave;
        for (int i=0;i<contadorEquiposPorLlave;i++){
            Equipo auxiliar = equipos.get(i);
            if (!auxiliar.isAutorizacion()){
                equipos.remove(auxiliar);
                contadorEquiposPorLlave--;
            }
        }
    }
    public void semifinal(Llave llaveIzquierda, Llave llaveDerecha){
        //defino el numero de ronda
        this.nroRonda=2;
        //Instancio un objeto de partido para usar su metodo
        Partido partido = new Partido();
        //msj de bienvenida a semifinal
        JOptionPane.showMessageDialog(null,"Se jugaran las semifinales","Semifinales",JOptionPane.INFORMATION_MESSAGE);
        //Simular los partidos
        partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(0),llaveIzquierda.getEquiposDeLaLlave().get(1));

        partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(0),llaveDerecha.getEquiposDeLaLlave().get(1));
        //remuevo a los perdedores
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
    }
    public void finalDelTorneo(Llave llaveIzquierda, Llave llaveDerecha){
        //definimos el nro de la ronda
        this.nroRonda=3;
        //muestro por pantalla un msj de bienvenida a la final
        JOptionPane.showMessageDialog(null,"Se jugara la final","Final",JOptionPane.INFORMATION_MESSAGE);

        // Instancia un objeto de partido para usar su metodo
        Partido partido = new Partido();
        //Simulamos el partido final
        Equipo equipo=partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(0),llaveIzquierda.getEquiposDeLaLlave().get(0) );

        //Mostramos quien gano el partido
        JOptionPane.showMessageDialog(null,"El ganador del torneo es: "+equipo.getNombre(),"Ganador del torneo",JOptionPane.INFORMATION_MESSAGE);



    }
}
