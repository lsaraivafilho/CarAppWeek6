package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ClientDetails;

public class ClientDetailsHelper {
	static EntityManagerFactory emfactory =	Persistence.createEntityManagerFactory("CarApp");
			public void insertNewClientDetails(ClientDetails s) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
			}
			public List<ClientDetails> getClients() {
			EntityManager em = emfactory.createEntityManager();
			List<ClientDetails> allDetails = em.createQuery("SELECT d FROM client_details d").getResultList();
			return allDetails;
			}
			
			public void deleteClient(ClientDetails toDelete) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<ClientDetails> typedQuery = em.createQuery("select detail from client_details detail where detail.id = :selectedId", ClientDetails.class);
				typedQuery.setParameter("selectedId", toDelete.getId());
				typedQuery.setMaxResults(1);
				ClientDetails result = typedQuery.getSingleResult();
				em.remove(result);
				em.getTransaction().commit();
				em.close();

			}
			public ClientDetails searchForClientDetailsById(Integer tempId) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				ClientDetails found = em.find(ClientDetails.class, tempId);
				em.close();
				return found;
			}
			public void updateList(ClientDetails toEdit) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				em.merge(toEdit);
				em.getTransaction().commit();
				em.close();
				}


}
