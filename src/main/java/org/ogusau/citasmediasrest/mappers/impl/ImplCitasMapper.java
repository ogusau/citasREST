package org.ogusau.citasmediasrest.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ogusau.citasmediasrest.mappers.interfaces.ICitasMapper;
import org.ogusau.model.entities.Cita;
import org.ogusau.model.entities.Diagnostico;
import org.ogusau.model.mappedentities.CitasMapped;

public class ImplCitasMapper implements ICitasMapper{
	
	private EntityManager manager;
	private static EntityManagerFactory emf;
	
    public ImplCitasMapper() {
		emf = Persistence.createEntityManagerFactory("persistence_sqlserver");
	}

	@Override
	public List<Cita> getCitasUsuarioID(int idUsuario) {
		manager = emf.createEntityManager();
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			manager.getTransaction().begin();
			
			citas = manager.createQuery("SELECT s FROM Cita s WHERE s.idPaciente = :idUsuario OR s.idMedico = :idUsuario", Cita.class).setParameter("idUsuario", idUsuario).getResultList();

			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		}
		
		return citas;
	}

	@Override
	public List<Cita> getAllCitas() {
		manager = emf.createEntityManager();
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			manager.getTransaction().begin();
			
			citas = manager.createQuery("SELECT s FROM Cita s", Cita.class).getResultList();

			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		}
		
		return citas;
	}

	@Override
	public void createCita(Cita cita) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			manager.persist(cita);
			
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
	public void deleteCita(int idCita) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			manager.createQuery("DELETE FROM Cita c WHERE c.idCita = :idCita").setParameter("idCita", idCita).executeUpdate();

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
	public void updateCita(Cita cita) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			Cita c = manager.find(Cita.class, cita.getIdCita());
			c.setDiagnostico(cita.getDiagnostico());
			c.setFechaHora(cita.getFechaHora());
			c.setIdMedico(cita.getIdMedico());
			c.setIdPaciente(cita.getIdPaciente());
			c.setMotivoCita(cita.getMotivoCita());

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
	
	private List<CitasMapped> map(List<Cita> citas) {
		List<CitasMapped> citasMapped = new ArrayList<CitasMapped>();
		
		for(Cita c: citas) {
			CitasMapped cm = new CitasMapped();
			cm.setDiagnostico(c.getDiagnostico());
			cm.setFechaHora(c.getFechaHora());
			cm.setIdCita(c.getIdCita());
			cm.setMotivoCita(c.getMotivoCita());
			
			citasMapped.add(cm);
		}
		return citasMapped;
	}

	@Override
	public void addDiagnostico(int idCita, Diagnostico diagnostico) {
		manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			Cita c = manager.find(Cita.class, idCita);
			c.setDiagnostico(diagnostico);

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
