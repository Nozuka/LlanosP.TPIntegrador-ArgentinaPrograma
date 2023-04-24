package org.example.clases;

import org.example.enumeraciones.Resultado;

public class Equipo {
    private boolean autorizacion = true;
    private String nombre;
    private Resultado resultadoEnElPartido;
    private int cantGolesEnElTorneo;
//constructor vacio
    public Equipo() {
    }
//constructor para nombrar a los equipos que ; no entiendo porque lo necesito
//poner, si abajo ya esta (pero agrupado)
    public Equipo(String nombre){
        this.nombre = nombre;
    }
//constructor lleno
    public Equipo(boolean autorizacion, String nombre, Resultado resultadoEnElPartido, int cantGolesEnElTorneo) {
        this.autorizacion = autorizacion;
        this.nombre = nombre;
        this.resultadoEnElPartido = resultadoEnElPartido;
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }
//getter & setter
    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Resultado getResultadoEnElPartido() {
        return resultadoEnElPartido;
    }

    public void setResultadoEnElPartido(Resultado resultadoEnElPartido) {
        this.resultadoEnElPartido = resultadoEnElPartido;
    }

    public int getCantGolesEnElTorneo() {
        return cantGolesEnElTorneo;
    }

    public void setCantGolesEnElTorneo(int cantGolesEnElTorneo) {
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }
    public void sumarGolesNuevos(int nuevosGoles){
        this.cantGolesEnElTorneo+=nuevosGoles;
    }
}
