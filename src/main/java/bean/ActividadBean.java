/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;

/**
 *
 * @author jonat
 */
public class ActividadBean implements Serializable{
    
    private int idActividad;
    private String titulo;
    private  String descripcion;
    private double calificacion;
    private String observacion;
}
