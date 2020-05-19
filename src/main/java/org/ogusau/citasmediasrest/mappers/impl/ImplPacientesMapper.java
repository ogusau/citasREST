package org.ogusau.citasmediasrest.mappers.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ogusau.citasmediasrest.mappers.interfaces.IPacientesMapper;
import org.ogusau.model.entities.Paciente;

public class ImplPacientesMapper implements IPacientesMapper{
	
	private EntityManager manager;
	private static EntityManagerFactory emf;
	
	public ImplPacientesMapper() {
		emf = Persistence.createEntityManagerFactory("persistence_sqlserver");
	}

	@Override
	public void addPaciente(Paciente paciente) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.persist(paciente);
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
	public List<Paciente> getPacientes() {
		manager = emf.createEntityManager();
		List<Paciente> pacientes = null;
		
		try {
			manager.getTransaction().begin();	
			pacientes = manager.createQuery("FROM Paciente", Paciente.class).getResultList();
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		};
		
		return pacientes;
	}

	@Override
	public Paciente getPaciente(int pacienteId) {
		manager = emf.createEntityManager();
		Paciente paciente = null;
		
		try {
			manager.getTransaction().begin();
			paciente = manager.createQuery("FROM Paciente WHERE id = :pacienteId AND activo = 1", Paciente.class)
					.setParameter("pacienteId", pacienteId).getSingleResult();
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		};
		
		return paciente;
	}

	@Override
	public void deletePaciente(int pacienteId) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();

			manager.createQuery("UPDATE Paciente p SET p.activo = 0 WHERE p.id = :pacienteId AND p.activo = 1")
					.setParameter("pacienteId", pacienteId).executeUpdate();
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

	@Override
	public void updatePaciente(Paciente paciente) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			Paciente p = manager.find(Paciente.class, paciente.getId());
			p.setNombre(paciente.getNombre());
			p.setApellidos(paciente.getApellidos());
			p.setClave(paciente.getClave());
			p.setDireccion(paciente.getDireccion());
			p.setNss(paciente.getNss());
			p.setNumTarjeta(paciente.getNumTarjeta());
			p.setTelefono(paciente.getTelefono());
			p.setUsuario(paciente.getUsuario());

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
}
