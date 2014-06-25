package uy.edu.ort.dao.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import uy.edu.ort.model.Trace;
import uy.edu.ort.dao.TraceDao;
import uy.edu.ort.exception.GenericException;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class TraceDaoImpl extends ObjectDaoImpl<Trace> implements TraceDao {
    @Override
    public List<Trace> obtenerTodos() throws GenericException {
        DetachedCriteria criteria = DetachedCriteria.forClass(Trace.class);
        criteria.addOrder(Order.desc( "fecha" ));
        return hibernateTemplate.findByCriteria(criteria);
    }
}
