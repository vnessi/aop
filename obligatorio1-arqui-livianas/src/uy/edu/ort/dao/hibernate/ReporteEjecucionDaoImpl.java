/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.dao.hibernate;

import java.util.List;
import uy.edu.ort.dao.ReporteEjecucionDao;
import uy.edu.ort.model.ReporteEjecucion;

/**
 *
 * @author Bruno
 */
public class ReporteEjecucionDaoImpl extends ObjectDaoImpl<ReporteEjecucion> implements ReporteEjecucionDao {

    @Override
    public List<List<String>> promedioEjecucionServicio() {
        return hibernateTemplate.find("SELECT new list(re.servicio, cast(avg(re.tiempo) as string)) from ReporteEjecucion as re group by re.servicio");
    }

    @Override
    public List<String> servicioMasRapido() {
        List<List<String>> result = hibernateTemplate.find("SELECT new list(re.servicio, cast(re.tiempo as string)) from ReporteEjecucion as re order by re.tiempo asc");
        return result.get(0);
    }

    @Override
    public List<String> servicioMasLento() {
        List<List<String>> result = hibernateTemplate.find("SELECT new list(re.servicio, cast(re.tiempo as string)) from ReporteEjecucion as re order by re.tiempo desc");
        return result.get(0);
    }
}
