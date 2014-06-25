/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.ort.dao.TraceDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Trace;
import uy.edu.ort.service.TraceService;

/**
 *
 * @author victor
 */
public class TraceServiceImpl implements TraceService {

    TraceDao traceDao;

    public void setTraceDao(TraceDao traceDao) {
        this.traceDao = traceDao;
    }
    
    @Override
    @Transactional
    public void agregarTrace(Trace t) {
        try {
            traceDao.guardar(t);
        } catch (GenericException ex) {
            Logger.getLogger(TraceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Trace> listar() {
        try {
            return traceDao.obtenerTodos();
        } catch (GenericException ex) {
            Logger.getLogger(TraceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
