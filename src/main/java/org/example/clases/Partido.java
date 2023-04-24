package org.example.clases;

import org.example.enumeraciones.Resultado;

import javax.swing.*;

public class Partido {
    private int golesEquipoLocal=2;
    private int golesEquipoVisitante=3;

    public Partido() {
    }

    public Partido(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }
    public Equipo simularPartido(Equipo equipolocal ,Equipo equipovisitante){
        //Muestro el resultado del partido
        JOptionPane.showMessageDialog(null,equipolocal.getNombre()+" "+this.golesEquipoLocal+" - "+this.golesEquipoVisitante+" "+equipovisitante.getNombre(),"Resultado",JOptionPane.INFORMATION_MESSAGE);

        //se sumo los goles a los equipos
        equipolocal.sumarGolesNuevos(this.golesEquipoLocal);
        equipovisitante.sumarGolesNuevos(this.golesEquipoVisitante);

        //Logica de el partido
        if (this.golesEquipoLocal>this.golesEquipoVisitante) {
            equipovisitante.setAutorizacion(false);
            equipovisitante.setResultadoEnElPartido(Resultado.PERDEDOR);
            equipolocal.setResultadoEnElPartido(Resultado.GANADOR);
            JOptionPane.showMessageDialog(null,"Ganó "+equipolocal.getNombre(),"Resultado",JOptionPane.INFORMATION_MESSAGE);
            return equipolocal;
        }else if (this.golesEquipoLocal==this.golesEquipoVisitante) {
            JOptionPane.showMessageDialog(null, "Se jugará el desempate entre " + equipolocal.getNombre() + " - " + equipovisitante.getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            equipolocal.setResultadoEnElPartido(Resultado.EMPATE);
            equipovisitante.setResultadoEnElPartido(Resultado.EMPATE);
        }else {
            equipolocal.setAutorizacion(false);
            equipolocal.setResultadoEnElPartido(Resultado.PERDEDOR);
            equipovisitante.setResultadoEnElPartido(Resultado.GANADOR);
            JOptionPane.showMessageDialog(null,"Ganó "+equipovisitante.getNombre(),"Resultado",JOptionPane.INFORMATION_MESSAGE);
            return  equipovisitante;
        }
    return null;
    }
}
