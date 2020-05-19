package org.ogusau.citasmediasrest.mappers.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ogusau.citasmediasrest.mappers.interfaces.ILoginMapper;
import org.ogusau.security.User;

public class ImplLoginMapper implements ILoginMapper{
	
	private EntityManager manager;
	private static EntityManagerFactory emf;
	
	public ImplLoginMapper(){
		emf = Persistence.createEntityManagerFactory("persistence_sqlserver");
	};

	@Override
	public boolean login(User user) {
		manager = emf.createEntityManager();
		try {
			manager.getTransaction().begin();
			
			Long existeUsuario =  manager.createQuery("SELECT COUNT(*) FROM Usuario WHERE usuario = :usuario AND password = :password AND activo = 1", Long.class)
					.setParameter("usuario", user.getUsuario())
					.setParameter("password", user.getPassword())
					.getSingleResult();
			
			manager.getTransaction().commit();
			
			if(existeUsuario == 0)
				return false;
			else
				return true;
			
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			System.out.println("HA OCURRIDO UN ERROR...");
		}
		finally {
			manager.close();
		}
		return false;
	}

}
