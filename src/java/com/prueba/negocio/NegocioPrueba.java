/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.negocio;

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
    private RespuestaDatos wsRespuesta = new RespuestaDatos();

    public NegocioPrueba() {
    }

    public Respuesta wsRespuesta(List<String> parametros) {
        respuesta = new Respuesta();

        try {

            respuesta = wsRespuesta.wsRespuesta(parametros);

        } catch (Exception e) {

            e.printStackTrace(new PrintWriter(writer));
        }
        return respuesta;

    }

}
