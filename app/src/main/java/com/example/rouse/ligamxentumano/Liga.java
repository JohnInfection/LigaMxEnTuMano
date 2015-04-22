package com.example.rouse.ligamxentumano;

/**
 * Created by Rouse on 23/03/2015.
 * Descripcion: Clase tomada como pojo  y solamente contendra setter y getter
 */
public class Liga {
    int id,jg,jp,je,gf,gc,difGoles,pntsGoles,goles,jj,jf;
    String nomEq,logo,nomJugador;

    //date horario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJg() {
        return jg;
    }

    public void setJg(int jg) {
        this.jg = jg;
    }

    public int getJe() {
        return je;
    }

    public void setJe(int je) {
        this.je = je;
    }

    public int getGf() {
        return gf;
    }

    public void setGf(int gf) {
        this.gf = gf;
    }

    public int getPntsGoles() {
        return pntsGoles;
    }

    public void setPntsGoles(int pntsGoles) {
        this.pntsGoles = pntsGoles;
    }




    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

     public String getNomJugador() {
        return nomJugador;
    }

    public void setNomJugador(String nomJugador) {
        this.nomJugador = nomJugador;
    }

    public String getNomEq() {
        return nomEq;
    }

    public void setNomEq(String nomEq) {
        this.nomEq = nomEq;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getDifGoles() {
        return difGoles;
    }

    public void setDifGoles(int difGoles) {
        this.difGoles = difGoles;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getJp() {
        return jp;
    }

    public void setJp(int jp) {
        this.jp = jp;
    }

    public int getJj() {
        return jj;
    }

    public void setJj(int jj) {
        this.jj = jj;
    }

    public int getJf() {
        return jf;
    }

    public void setJf(int jf) {
        this.jf = jf;
    }
}
