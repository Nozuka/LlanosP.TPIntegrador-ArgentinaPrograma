package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Jugador {

    private Equipo equipoSeleccionado;
    private int puntaje;

    public Jugador() {
    }

    public Jugador(Equipo equipoSeleccionado, int puntaje) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.puntaje = puntaje;
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    //nuevo metodo
    public void elegirEquipo(List<Equipo> listaEquipos){
        String listDelosEquiposEnMensaje="Seleccione su equipo: \n";
        for (int i=0;i<listaEquipos.size();i++){
            listDelosEquiposEnMensaje+=(i+1)+". "+listaEquipos.get(i).getNombre()+"\n";
        }
        JOptionPane.showMessageDialog(null,listDelosEquiposEnMensaje,"Seleccione su equipo",JOptionPane.INFORMATION_MESSAGE);
        int indiceEquipo = 0;
        do {
            indiceEquipo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice del equipo que quiere seleccionar","Seleccion de equipo",JOptionPane.INFORMATION_MESSAGE))-1;
        }while(indiceEquipo<0||indiceEquipo>7);

        JOptionPane.showMessageDialog(null,"Seleccionaste a: "+listaEquipos.get(indiceEquipo).getNombre());
        this.equipoSeleccionado=listaEquipos.get(indiceEquipo);
    }
    //suma de puntos para que el equipo que gane cada partido
    public void sumarPuntos(){
        if (equipoSeleccionado.isAutorizacion()){
            puntaje++;
        }
    }
}
