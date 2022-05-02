/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controler;

import com.google.gson.Gson;
import com.prueba.negocio.NegocioPrueba;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author adria
 */
@WebService(serviceName = "wsprueba")
public class webservice {

    /**
     * Web service operation
     */
    Respuesta respuesta = new Respuesta();
    private static String resp = "";
    private Gson gson = new Gson();
    private String res = resp;
    Writer writer = null;
    NegocioPrueba negocioPrueba = new NegocioPrueba();

    @WebMethod(operationName = "operation")
    public String operation(@WebParam(name = "dtoImput") List<String> parametros) {
        //TODO write your implementation code here:

        try {
            respuesta = negocioPrueba.wsRespuesta(parametros);
        } catch (Exception e) {

            e.printStackTrace(new PrintWriter(writer));
        } finally {
            res = gson.toJson(respuesta);
        }

        return res;
    }

}
