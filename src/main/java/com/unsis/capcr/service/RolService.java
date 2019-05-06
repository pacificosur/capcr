/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Rol;
import com.unsis.capcr.model.IRolModel;
import com.unsis.capcr.model.RolModel;
import java.util.List;

/**
 *
 * @author LabTW12
 */
public class RolService implements IRolService{
    IRolModel iRolModel = new RolModel();
    @Override
    public List<Rol> obtenerRoles() {
        return iRolModel.obtenerRoles();
    }
}
