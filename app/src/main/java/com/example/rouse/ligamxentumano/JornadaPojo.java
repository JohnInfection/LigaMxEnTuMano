package com.example.rouse.ligamxentumano;

/**
 * Created by CeSar on 27/03/2015.
 */
public class JornadaPojo {

    String eqLocal, eqVisitante, horario, lugar, resultado;
    int id;

    public String getEqLocal() {
        return eqLocal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEqLocal(String eqLocal) {
        this.eqLocal = eqLocal;
    }

    public String getEqVisitante() {
        return eqVisitante;
    }

    public void setEqVisitante(String eqVisitante) {
        this.eqVisitante = eqVisitante;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
