
package com.prueba.controler;

/**
 * 
 * Entidad de Mapeo de respuesta.

 * Fecha 21/09/2021
 * @author kgalarza
 * @version 1.0
 */
public class Respuesta {

    private String CodResponse;
    private String MsjResponse;
    private Object data;
    

    public String getCodResponse() {
        return CodResponse;
    }

    public void setCodResponse(String CodResponse) {
        this.CodResponse = CodResponse;
    }

    public String getMsjResponse() {
        return MsjResponse;
    }

    public void setMsjResponse(String MsjResponse) {
        this.MsjResponse = MsjResponse;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClsResponse{" + "CodResponse=" + CodResponse + ", MsjResponse=" + MsjResponse + '}';
    }

   
    
    
}
