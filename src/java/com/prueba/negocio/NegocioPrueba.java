/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.negocio;

import com.graba.log.clases.ClsGrabaLog;
import com.prueba.controler.Respuesta;
import com.prueba.datos.RespuestaDatos;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author adria
 */
public class NegocioPrueba {

    private Respuesta respuesta;
    Writer writer = null;
    private String error = "";
    private short num = 3;
    private final ClsGrabaLog ObjLOG = new ClsGrabaLog("wsPruebas");
    private RespuestaDatos wsRespuesta = new RespuestaDatos();

    public NegocioPrueba() {
    }

    public Respuesta wsRespuesta(List<String> parametros) {
        respuesta = new Respuesta();

        try {
            if (parametros.size() > 0) {
                respuesta = wsRespuesta.wsRespuesta(parametros);
            } else {
                respuesta.setCodResponse("02");
                respuesta.setMsjResponse("DEBE ENVIAR PARÁMETROS.");
            }
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(writer));
            error = writer.toString();
            respuesta.setCodResponse("99");
            respuesta.setMsjResponse("Error en [" + "wsRespuesta" + "] ocurrió una excepción");
            ObjLOG.printmsg(num, getClass().getSimpleName() + " - " + "wsRespuesta", " -" + "CAPA DE NEGOCIO" + "-  Error:  " + error);

        }
        return respuesta;

    }

}
