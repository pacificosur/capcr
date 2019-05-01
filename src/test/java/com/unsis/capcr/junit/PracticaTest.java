/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.junit;
import com.unsis.capcr.entity.Practica;
import com.unsis.capcr.model.IPracticaModel;
import com.unsis.capcr.model.PracticaModel;
import com.unsis.capcr.service.IPracticaService;
import com.unsis.capcr.service.PracticaService;
import java.sql.Date;
import junit.framework.TestCase;

/**
 *
 * @author LabTW08
 */
public class PracticaTest extends TestCase{
    IPracticaService service = new PracticaService();
    IPracticaModel pm = new PracticaModel();
    public void insertar(){
       java.util.Date d = new java.util.Date(); 
       Practica practica = new Practica("6001","P1","10","03",new java.sql.Date(d.getTime()),null,null);
       service.crearPractica(practica);
       practica = service.getPractica("6001");
       assertEquals("P1",practica.getNombre());
    }
}
