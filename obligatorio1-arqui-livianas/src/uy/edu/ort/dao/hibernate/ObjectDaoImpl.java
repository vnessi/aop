/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.dao.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.orm.hibernate3.HibernateTemplate;
import uy.edu.ort.dao.ObjetoDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.EntidadPersistente;

/**
 *
 * @author Bruno
 */
public class ObjectDaoImpl<T> implements ObjetoDao<T> {

    protected String entityName;
    protected Class<T> type;
    protected HibernateTemplate hibernateTemplate;
    
    public ObjectDaoImpl(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void guardar(T entity) {
        hibernateTemplate.save(entity);
    }

    @Override
    public void borrar(T entity) {
        hibernateTemplate.delete(entity);
    }

    @Override
    public T obtenerPorPK(EntidadPersistente obj) throws GenericException {
       return (T)hibernateTemplate.find("from "+getEntityName()+" where id = "+obj.getId()).get(0);
    }

    @Override
    public List<T> obtenerTodos() throws GenericException {
        return hibernateTemplate.find("from "+getEntityName());
    }

    @Override
    public List<T> obtenerPorPropiedad(String prop, Object val) throws GenericException {
        return hibernateTemplate.find("from "+getEntityName()+" where "+prop+" = "+val);
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
