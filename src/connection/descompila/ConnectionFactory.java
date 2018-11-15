package connection.descompila;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("meu-PU");

	
	public static EntityManager getEntityManager() {

		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("meu-PU");
		}
		

		return emf.createEntityManager();
	}

}
