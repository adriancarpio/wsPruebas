/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.datos;

import com.prueba.controler.ClsDatos;
import com.prueba.controler.Datos;
import com.prueba.controler.Respuesta;
import com.prueba.db.conexion.DBConnectionOracleDB;
import com.prueba.util.EntityMapper;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author adria
 */
public class RespuestaDatos {

    private Respuesta respuesta;
    private Connection cn = null;
    Writer writer = null;
    private CallableStatement statement;
    private CallableStatement response_statement;
    private DBConnectionOracleDB dbcodb = new DBConnectionOracleDB();

    public RespuestaDatos() {
    }

    public Respuesta wsRespuesta(List<String> parametros) {
        String sql = "{ CALL APP_TESIS.PKG_TI_SEG_TRX_ADMINISTRADOR.PUB_CRUD_ROL(?,?,?,?,?,?,?,?,?)}";
        respuesta = new Respuesta();
        List<Datos> datos = new ArrayList();

        try {

            cn = dbcodb.getConnection();

            if (cn != null) {
                statement = cn.prepareCall(sql);

//                statement.setObject(1, (parametros.get(0)));
//                statement.setObject(2, (parametros.get(1)));
//                statement.setObject(3, (parametros.get(2)));
//                statement.setObject(4, (parametros.get(3)));
//                statement.setObject(5, (parametros.get(4)));
//                statement.setObject(6, (parametros.get(5)));
//                statement.registerOutParameter(7, OracleTypes.CURSOR);
//                statement.registerOutParameter(8, OracleTypes.VARCHAR);
//                statement.registerOutParameter(9, OracleTypes.VARCHAR);
//                statement.execute();
                int iCodResp = 0;
                int iMsjresp = 0;
                int iCursor = 0;

                for (int i = 0; i < parametros.size(); i++) {
                    statement.setObject(i + 1, (parametros.get(i) != null ? parametros.get(i) : null));
                }
                int size = parametros.size();
                iCursor = ++size;
                iCodResp = ++size;
                iMsjresp = ++size;
                //respuesta.setCodResponse(statement.getString(8));
                //respuesta.setMsjResponse(statement.getString(9));
                statement.registerOutParameter(iCursor, OracleTypes.CURSOR);
                statement.registerOutParameter(iCodResp, OracleTypes.VARCHAR);
                statement.registerOutParameter(iMsjresp, OracleTypes.VARCHAR);
                statement.execute();
                respuesta.setCodResponse(statement.getString(iCodResp));
                respuesta.setMsjResponse(statement.getString(iMsjresp));
                if (respuesta.getCodResponse().equals("00")) {
                    ResultSet rs = (ResultSet) statement.getObject(iCursor);

                    //ResultSet rs = (ResultSet) statement.getObject(7);
                    EntityMapper<ClsDatos> mapeo = new EntityMapper<>();
                    List<ClsDatos> list = mapeo.mapResultSetToListString(rs, ClsDatos.class);

//                    while (rs.next()) {
//                        Datos bean = new Datos();
//                        bean.setID(rs.getString("ID") != null ? rs.getString("ID") : "");
//                        bean.setNombre(rs.getString("NOMBRE") != null ? rs.getString("NOMBRE") : "");
//                        bean.setDescripcion(rs.getString("DESCRIPCION") != null ? rs.getString("DESCRIPCION") : "");
//                        bean.setEstado(rs.getString("ESTADO") != null ? rs.getString("ESTADO") : "");
//                        bean.setFechaIngreso(rs.getString("FECHA_INGRESO") != null ? rs.getString("FECHA_INGRESO") : "");
//                        bean.setUsuarioIngreso(rs.getString("USUARIO_INGRESO") != null ? rs.getString("USUARIO_INGRESO") : "");
//                        bean.setFechaModificacion(rs.getString("FECHA_MODIFICACION") != null ? rs.getString("FECHA_MODIFICACION") : "");
//                        bean.setUsuarioModificacion(rs.getString("USUARIO_MODIFICACION") != null ? rs.getString("USUARIO_MODIFICACION") : "");
//                        datos.add(bean);
//                    }
//                    respuesta.setData(datos);
                    respuesta.setData(list);
                }
            } else {
                System.out.println("error en la conexion");
            }
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(writer));
        }
        return respuesta;
    }
}