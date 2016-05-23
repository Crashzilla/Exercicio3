package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class GenericDao<T> implements Dao<T>{

	private final Class<T> classe;
	protected EntityManager em;
	
	public GenericDao(Class<T> classe) {
		super();
		this.classe = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em=JpaUtil.geEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
		System.out.println(entidade + " adicionada com sucesso");
	}

	@Override
	public List<T> listar() {
		em=JpaUtil.geEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(classe);
		Root<T> c = cq.from(classe);
		cq.select(c);
		return em.createQuery(cq).getResultList();
	}

	@Override
	public void atualizar(T entidade) {
		em=JpaUtil.geEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(T entidade) {
		em=JpaUtil.geEntityManager();
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public T buscar(int id) {
		em=JpaUtil.geEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}	
}
