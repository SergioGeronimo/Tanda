/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanda.DB;
import java.sql.Date;

public class Pago {
    
    private int pago;
    private String CURP;
    private Date fecha;
    private int idTanda;
    private boolean pagado;
    private boolean aceptado;

    public Pago(int pago, String CURP, Date fecha, int idTanda, boolean pagado, boolean aceptado) {
        this.pago = pago;
        this.CURP = CURP;
        this.fecha = fecha;
        this.idTanda = idTanda;
        this.pagado = pagado;
        this.aceptado = aceptado;
    }

    public boolean isAceptado() {
        return aceptado;
    }
    
    public int isAceptadoSQL(){
        return (this.aceptado ? 1 : 0);
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public int getId() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setFecha(String fecha){
        this.fecha = Date.valueOf(fecha);
    }

    public int getIdTanda() {
        return idTanda;
    }

    public void setIdTanda(int idTanda) {
        this.idTanda = idTanda;
    }

    public boolean isPagado() {
        return pagado;
    }
    
    public int isPagadoSQL(){
        return (isPagado() ? 1 : 0);
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    
    
    
}
