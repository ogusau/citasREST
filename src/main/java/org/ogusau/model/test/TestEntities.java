package org.ogusau.model.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ogusau.citasmediasrest.utilities.ResponseBuilder;
import org.ogusau.citasmediasrest.utilities.ServiceResponse;
import org.ogusau.citasmediasrest.utilities.ServiceStatus;
import org.ogusau.model.entities.Usuario;

public class TestEntities {
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	public static void main1(String[] args) {
		emf = Persistence.createEntityManagerFactory("persistence_sqlserver");
		manager = emf.createEntityManager();
		//List<Cita> citas = manager.createQuery("Cita", Cita.class).getResultList();
		
		try {
			manager.getTransaction().begin();
			Usuario u = manager.find(Usuario.class, 2);
			System.out.println("USUARIO RECUPERADO: " + u.getNombre() + " " + u.getApellidos());
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		}
	}
	
	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("persistence_sqlserver");
		manager = emf.createEntityManager();
		//List<Cita> citas = manager.createQuery("Cita", Cita.class).getResultList();
		
		try {
			manager.getTransaction().begin();
			List<Usuario> u = manager.createQuery("FROM Usuario", Usuario.class).getResultList();
			ServiceResponse sr = new ServiceResponse(u, new ServiceStatus("200", "OK"));
			
			System.out.println( ResponseBuilder.buildReponse(sr) );
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		}
	}

}
