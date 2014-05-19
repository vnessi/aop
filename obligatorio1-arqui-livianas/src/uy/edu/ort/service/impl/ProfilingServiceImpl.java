/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.ort.dao.ReporteEjecucionDao;
import uy.edu.ort.model.ReporteEjecucion;
import uy.edu.ort.service.ProfilingService;


/**
 *
 * @author Bruno
 */
public class ProfilingServiceImpl implements ProfilingService{

    ReporteEjecucionDao reporteEjecucionDao;

    public void setReporteEjecucionDao(ReporteEjecucionDao r) {
        this.reporteEjecucionDao = r;
    }
    
    @Transactional
    @Override
    public List<List<String>> promedioEjecucionServicio() {
        return reporteEjecucionDao.promedioEjecucionServicio();
    }

    @Transactional
    @Override
    public List<String> servicioMasRapido() {
         return reporteEjecucionDao.servicioMasRapido();
    }

    @Transactional
    @Override
    public List<String> servicioMasLento() {
        return reporteEjecucionDao.servicioMasLento();
    }
    
}
