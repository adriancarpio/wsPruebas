/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controler;

import com.google.gson.Gson;
import com.graba.log.clases.ClsGrabaLog;
import com.prueba.negocio.NegocioPrueba;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

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
    private short num = 3;
    private String res = resp;
    private static String EmpyString = "";
    private String error = EmpyString;
    private final ClsGrabaLog ObjLOG = new ClsGrabaLog("wsPruebas");
    private String response = EmpyString;
    Writer writer = null;
    NegocioPrueba negocioPrueba = new NegocioPrueba();

    @WebMethod(operationName = "operation")
    public String operation(
            @WebParam(name = "procedimiento") @XmlElement(required = true, nillable = false) String procedimiento,
            @WebParam(name = "dtoImput") List<String> parametros) {
        //TODO write your implementation code here:

        try {
            switch (procedimiento) {
                case "PUB_CRUD_ROL":
                    respuesta = negocioPrueba.wsRespuesta(parametros);
                    break;
                default:
                    respuesta.setCodResponse("99");
                    respuesta.setMsjResponse("No existe el procedimiento");
            }
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(writer));
            error = writer.toString();
            respuesta.setCodResponse("99");
            respuesta.setMsjResponse("Error al realizar la Transacción.");
            ObjLOG.printmsg(num, getClass().getSimpleName() + " - " + "wsRespuesta", " -" + "CAPA DE PRESENTACION" + "-  ERROR:  " + error);
            response = gson.toJson(respuesta);
        } finally {
            response = gson.toJson(respuesta);
            ObjLOG.printmsg(num, getClass().getSimpleName() + " - " + "wsRespuesta", " -" + "CAPA DE PRESENTACION" + "-  ERROR:  " + error);
        }

        return response;
    }

}
