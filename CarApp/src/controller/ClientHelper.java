package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Client;

public class ClientHelper {
	
		static EntityManagerFactory emfactory =	Persistence.createEntityManagerFactory("CarApp");
		public void insertClient(Client s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		}
	
		public List<Client> showAllClients() {
		EntityManager em = emfactory.createEntityManager();
		List<Client> allClients = em.createQuery("SELECT s FROM client s").getResultList();
		return allClients;
		}
		public Client findClient(String nameToLookUp) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Client> typedQuery = em.createQuery("select sh from Client sh where sh.clientName = :selectedName",		Client.class);
	
			typedQuery.setParameter("selectedName", nameToLookUp);
			typedQuery.setMaxResults(1);
			Client foundShopper;
			try {
			foundShopper = typedQuery.getSingleResult();
			} catch (NoResultException ex) {
			foundShopper = new Client(nameToLookUp);
			}
			em.close();
			return foundShopper;
			}
		}
