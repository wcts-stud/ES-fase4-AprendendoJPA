package descompila.dao;

import java.util.List;

import javax.persistence.EntityManager;

import connection.descompila.ConnectionFactory;
import main.descompila.Categoria;

public class CategoriaDAO {

	EntityManager em = new ConnectionFactory().getEntityManager();
	
	
	/*
	 * Save in db
	 */
	public void save(Categoria c){
		
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			System.out.println("Erro: " +e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
	
	/*
	 * Update 
	 */
	public void update(Categoria c) {
		try {
			em.getTransaction().begin();
			if ( c.getId() < 0 ){
				em.persist(c);
			} else {
				em.merge(c);
				em.getTransaction().commit();
			}
			
		} catch (Exception e) {
			System.out.println("Erro: " +e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
	
	
	/*
	 * Find data
	 */
	public Categoria findById(Integer id){
		Categoria cat = null;
		
		try {
			cat = em.find(Categoria.class, id);
		} catch(Exception e) {
			System.out.println("Erro: " +e);
		} finally {
			em.close();
		}
		
		
		return cat;		
	}
	
	
	
	/*
	 * List all
	 */
	public List<Categoria> findAll() {
		
		List<Categoria> cats = null;
		
		try {
			cats = em.createQuery("from Categoria c").getResultList();
			
		} catch (Exception e) {
			System.err.println("Erro ao listar todo os objetos: " +e);
			
		} finally {
			em.close();
		}
		
		return cats;
	}
	
	
	
	/*
	 * Remove
	 */
	public Categoria remove(int id) {
		Categoria c = null;
		
		try {
			c = em.find(Categoria.class, id);
					
			if (c != null) {
				em.getTransaction().begin();
				em.remove(c);
				em.getTransaction().commit();
			}
			
		} catch (Exception e){
			System.err.println("Falha ao remover: " +e);
			em.getTransaction().rollback();
			
		} finally {
			em.close();
		}
		
		return c;
	}
}
