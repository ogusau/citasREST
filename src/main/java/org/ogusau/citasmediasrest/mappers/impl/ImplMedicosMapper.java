package org.ogusau.citasmediasrest.mappers.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ogusau.citasmediasrest.mappers.interfaces.IMedicosMapper;
import org.ogusau.model.entities.Medico;

public class ImplMedicosMapper implements IMedicosMapper{
	
	private EntityManager manager;
	private static EntityManagerFactory emf;
	
	public ImplMedicosMapper() {
		emf = Persistence.createEntityManagerFactory("persistence_sqlserver");
	}

	@Override
	public void addMedico(Medico medico) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.persist(medico);
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		}
		
		return;
	}

	@Override
	public List<Medico> getMedicos() {
		manager = emf.createEntityManager();
		List<Medico> medicos = null;
		
		try {
			manager.getTransaction().begin();	
			medicos = manager.createQuery("FROM Medico", Medico.class).getResultList();
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		};
		
		return medicos;
	}

	@Override
	public Medico getMedico(int medicoId) {
		manager = emf.createEntityManager();
		Medico medico = null;
		
		try {
			manager.getTransaction().begin();
			medico = manager.createQuery("FROM Medico WHERE id = :medicoId AND activo = 1", Medico.class)
					.setParameter("medicoId", medicoId).getSingleResult();
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		};
		
		return medico;
	}
	
	@Override
	public void updateMedico(Medico medico) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			Medico m = manager.find(Medico.class, medico.getId());
			m.setNombre(medico.getNombre());
			m.setApellidos(medico.getApellidos());
			m.setClave(medico.getClave());
			m.setNumColegiado(medico.getNumColegiado());
			m.setUsuario(medico.getUsuario());

			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		}
		
		return;
		
	}

	@Override
	public void deleteMedico(int medicoId) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();

			manager.createQuery("UPDATE Medico p SET p.activo = 0 WHERE p.id = :medicoId AND p.activo = 1")
					.setParameter("pacienteId", medicoId).executeUpdate();
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		};
		
		return;
	}
}
