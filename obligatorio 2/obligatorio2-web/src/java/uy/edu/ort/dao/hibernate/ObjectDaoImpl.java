package uy.edu.ort.dao.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import uy.edu.ort.dao.ObjetoDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.EntidadPersistente;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 *
 * Clase que implementa las operaciones DAO basicas utilizando Generics
 */
public class ObjectDaoImpl<T> implements ObjetoDao<T> {

    protected String entityName;
    protected Class<T> type;
    protected HibernateTemplate hibernateTemplate;

    public ObjectDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void guardar(T entity) {
        hibernateTemplate.merge(entity);
        hibernateTemplate.flush();
    }

//    @Override
//    public void modificar(long id, T entity) throws GenericException{
//        try{
//        entity = (T) hibernateTemplate.get(entity.getClass(), ((EntidadPersistente)entity).getId());
//        
//        hibernateTemplate.save(entity);
//        hibernateTemplate.flush();
//        }catch(DataAccessException ex){
//            throw new GenericException(ex.getMessage());
//        }
//    }
    @Override
    public void borrar(T entity) {
        hibernateTemplate.delete(entity);
        hibernateTemplate.flush();
    }

    @Override
    public T obtenerPorPK(EntidadPersistente obj) throws GenericException {
        List<T> ret = obtenerPorPropiedad("id", obj.getId().toString());
        if (ret.size() > 0) {
            hibernateTemplate.flush();
            return ret.get(0);
        }
        return null;
    }

    @Override
    public List<T> obtenerTodos() throws GenericException {
        List<T> ret = hibernateTemplate.find("from " + getEntityName());
        hibernateTemplate.flush();
        return ret;
    }

    @Override
    public List<T> obtenerPorPropiedad(String prop, Object val) throws GenericException {
        List<T> ret = hibernateTemplate.find("from " + getEntityName() + " as T where T." + prop + " = \'" + val + "\'");
        hibernateTemplate.flush();
        return ret;
    }

    public String getEntityName() {
        if (entityName == null) {
            Entity entity = type.getAnnotation(Entity.class);
            if (entity != null && !entity.name().equals("")) {
                entityName = entity.name();
            } else {
                entityName = type.getSimpleName();
            }
        }
        return entityName;
    }
}
