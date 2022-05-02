/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author adria
 */
@Entity
public class ClsDatos {

    @Id
    @Column(name = "ID")
    private String ID;
    @Column(name = "NOMBRE")
    private String NOMBRE;
    @Column(name = "DESCRIPCION")
    private String DESCRIPCION;
    @Column(name = "ESTADO")
    private String ESTADO;
    @Column(name = "FECHA_INGRESO")
    private String FECHA_INGRESO;
    @Column(name = "USUARIO_INGRESO")
    private String USUARIO_INGRESO;
    @Column(name = "FECHA_MODIFICACION")
    private String FECHA_MODIFICACION;
    @Column(name = "USUARIO_MODIFICACION")
    private String USUARIO_MODIFICACION;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    public void setFECHA_INGRESO(String FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    public String getUSUARIO_INGRESO() {
        return USUARIO_INGRESO;
    }

    public void setUSUARIO_INGRESO(String USUARIO_INGRESO) {
        this.USUARIO_INGRESO = USUARIO_INGRESO;
    }

    public String getFECHA_MODIFICACION() {
        return FECHA_MODIFICACION;
    }

    public void setFECHA_MODIFICACION(String FECHA_MODIFICACION) {
        this.FECHA_MODIFICACION = FECHA_MODIFICACION;
    }

    public String getUSUARIO_MODIFICACION() {
        return USUARIO_MODIFICACION;
    }

    public void setUSUARIO_MODIFICACION(String USUARIO_MODIFICACION) {
        this.USUARIO_MODIFICACION = USUARIO_MODIFICACION;
    }

    @Override
    public String toString() {
        return "ClsDatos{" + "ID=" + ID + ", NOMBRE=" + NOMBRE + ", DESCRIPCION=" + DESCRIPCION + ", ESTADO=" + ESTADO + ", FECHA_INGRESO=" + FECHA_INGRESO + ", USUARIO_INGRESO=" + USUARIO_INGRESO + ", FECHA_MODIFICACION=" + FECHA_MODIFICACION + ", USUARIO_MODIFICACION=" + USUARIO_MODIFICACION + '}';
    }

}
