
package com.prueba.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Esta clase ofrece la posibilidad de convertir un conjunto de datos (ResultSet) en cualquier clase
 * que contenga las anotaciones Entity y Column con el nombre del resultado.
 * 
 * fecha modificación: 15/08/2021
 * modify by: Kevin Galarza
 * 
 * @param <T> tipo de retorno para mapear los resultset al tipo de dato deseado.
 */
public class EntityMapper<T> {

    @SuppressWarnings("unchecked")
    public List<T> mapResultSetToListObject(ResultSet rs, Class outputClass) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException,
            NoClassDefFoundError{
        List<T> outputList = null;
//        try {
            // asegura de que el conjunto de resultados no es nulo
            if (rs != null) {
                // comprobar si outputClass tiene la anotación 'Entity'
                if (outputClass.isAnnotationPresent(Entity.class)) {
                    // obtener los metadatos del conjunto de resultados
                    ResultSetMetaData rsmd = rs.getMetaData();
                    // obtener todos los atributos de outputClass
                    Field[] fields = outputClass.getDeclaredFields();
                    while (rs.next()) {
                        T bean = (T) outputClass.newInstance();
                        for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
                            // obtener el nombre de la columna SQL
                            String columnName = rsmd.getColumnName(_iterator + 1);
                            // leer el valor de la columna SQL
                            Object columnValue = rs.getObject(_iterator + 1);
                            // iterar sobre los atributos outputClass para comprobar si algún atributo tiene la anotación 'Column' con el valor 'name' correspondiente
                            for (Field field : fields) {
                                if (field.isAnnotationPresent(Column.class)) {
                                    Column column = field.getAnnotation(Column.class);
                                    if (column.name().equalsIgnoreCase(columnName) && columnValue != null) {
                                        BeanUtils.setProperty(bean, field.getName(), columnValue);
                                        break;
                                    }
                                }
                            }
                        }
                        if (outputList == null) {
                            outputList = new ArrayList<>();
                        }
                        outputList.add(bean);
                    }
                } else {
                    // throw some error
                    System.out.println("No es una entidad");
                    return null;
                }
            } else {
                System.out.println("Conjunto de datos vacio");
                return null;
            }
//        } catch (IllegalAccessException | SQLException | InstantiationException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
        return outputList;
    }
    
     //@SuppressWarnings("unchecked")
    public List<T> mapResultSetToListString(ResultSet rs, Class outputClass) 
            throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException,
            NoClassDefFoundError{
        List<T> outputList = null;
         
//        try {
            // asegura de que el conjunto de resultados no es nulo
            if (rs != null) {
                // comprobar si outputClass tiene la anotación 'Entity'
                if (outputClass.isAnnotationPresent(Entity.class)) {
                    // obtener los metadatos del conjunto de resultados
                    ResultSetMetaData rsmd = rs.getMetaData();
                    // obtener todos los atributos de outputClass
                    Field[] fields = outputClass.getDeclaredFields();
                    while (rs.next()) {
                        T bean = (T) outputClass.newInstance();
                        for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
                            // obtener el nombre de la columna SQL
                            String columnName = rsmd.getColumnName(_iterator + 1);
                            // leer el valor de la columna SQL
                            Object columnValue = rs.getString(_iterator + 1);
                            // iterar sobre los atributos outputClass para comprobar si algún atributo tiene la anotación 'Column' con el valor 'name' correspondiente
                            for (Field field : fields) {
                                if (field.isAnnotationPresent(Column.class)) {
                                    Column column = field.getAnnotation(Column.class);
                                    if (column.name().equalsIgnoreCase(columnName) && columnValue != null) {
                                        BeanUtils.setProperty(bean, field.getName(), columnValue);
                                        break;
                                    }
                                }
                            }
                        }
                        if (outputList == null) {
                            outputList = new ArrayList<>();
                        }
                        outputList.add(bean);
                    }
                } else {
                    // throw some error
                    System.out.println("No es una entidad");
                    return null;
                }
            } else {
                System.out.println("Conjunto de datos vacio");
                return null;
            }
//        } catch (IllegalAccessException | SQLException | InstantiationException | InvocationTargetException |  e) {
//            System.out.println("=================================================");
//            System.out.println("Se cae aqui");
//            e.printStackTrace();
//        }
        return outputList;
    }
    
    public <T> T mapResultSetToObject(ResultSet rs, Class outputClass) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException,
            NoClassDefFoundError{
        T outputObject = null;
//        try {
            // asegúrese de que el conjunto de resultados no es nulo
            if (rs != null) {
                // comprobar si outputClass tiene la anotación 'Entity'
                if (outputClass.isAnnotationPresent(Entity.class)) {
                    // obtener los metadatos del conjunto de resultados
                    ResultSetMetaData rsmd = rs.getMetaData();
                    // obtener todos los atributos de outputClass
                    Field[] fields = outputClass.getDeclaredFields();
                    while (rs.next()) {
                        T bean = (T) outputClass.newInstance();
                        for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
                            // obtener el nombre de la columna SQL
                            String columnName = rsmd.getColumnName(_iterator + 1);
                            // leer el valor de la columna SQL
                            Object columnValue = rs.getObject(_iterator + 1);
                            // iterar sobre los atributos outputClass para comprobar si algún atributo tiene la anotación 'Column' con el valor 'name' correspondiente
                            for (Field field : fields) {
                                if (field.isAnnotationPresent(Column.class)) {
                                    Column column = field.getAnnotation(Column.class);
                                    if (column.name().equalsIgnoreCase(columnName) && columnValue != null) {
                                        BeanUtils.setProperty(bean, field.getName(), columnValue);
                                        break;
                                    }
                                }
                            }
                        }
                        if (outputObject == null) {
                            outputObject = (T) outputClass.newInstance();
                        }
                        outputObject = bean;
                    }

                } else {
                    // throw some error
                    return null;
                }
            } else {
                return null;
            }
//        } catch (IllegalAccessException | SQLException | InstantiationException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
        return outputObject;
    }

}
