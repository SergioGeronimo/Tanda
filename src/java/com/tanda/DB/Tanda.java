/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanda.DB;

public class Tanda {
    
    private int idTanda;
    private String CURP;
    private long monto;

    public Tanda(int idTanda, String CURP, long monto) {
        this.idTanda = idTanda;
        this.CURP = CURP;
        this.monto = monto;
    }

    public int getIdTanda() {
        return idTanda;
    }

    public void setIdTanda(int idTanda) {
        this.idTanda = idTanda;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }
    
    
    
}
