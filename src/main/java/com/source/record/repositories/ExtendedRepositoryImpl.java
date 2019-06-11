package com.source.record.repositories;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class ExtendedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> 
	implements BaseRepository<T, ID> {

	private JpaEntityInformation<T, ?> entityInformation;
	
	private EntityManager entityManager;
	
	public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByIds(ID... ids) {
		String queryString = "SELECT s FROM " + entityInformation.getEntityName() + " s WHERE s."
				+ entityInformation.getIdAttribute().getName() + " IN :ids";
		
		Query query = entityManager.createQuery(queryString);
		query.setParameter("ids", Arrays.asList(ids));
		return (List<T>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public T findStudentByParams(Map<String, Object> params, String filter) {
		/* "name = :name" -> filter */
		final String jpql = "FROM " + entityInformation.getEntityName() + " WHERE " + filter;
		
        Query query = entityManager.createQuery(jpql);
        for (Map.Entry<String, Object> value : params.entrySet())
            query.setParameter(value.getKey(), value.getValue());
        
        return (T) query.getSingleResult();
	}
}
