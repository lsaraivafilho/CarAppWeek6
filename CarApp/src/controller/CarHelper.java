package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;


public class CarHelper extends HttpServlet{
	 
	
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarApp");


	public void insertCar(ListCar ch) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ch);
		em.getTransaction().commit();
		em.close();
		
	}

	public void deleteCar(ListCar toDelete) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar>	typedQuery	=	em.createQuery("select	ch	from	ListCar	ch	where	ch.brand	=	:selectedBrand	and	ch.model	=	:selectedModel	",	ListCar.class);
	
		typedQuery.setParameter("selectedBrand",	toDelete.getBrand());
		typedQuery.setParameter("selectedModel",	toDelete.getModel());
		
		
		typedQuery.setMaxResults(1);
		try {
			ListCar	result	=	typedQuery.getSingleResult();
			em.remove(result);
			em.getTransaction().commit();
			em.close();
			}
			catch(NoResultException e) {
				System.out.println("Model or Brand not found.");
			}

	}

	public List<ListCar> searchForCarByModel(String model) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar>	typedQuery	=	em.createQuery("select	ch	from	ListCar 	ch	where	ch.model	=	:selectedModel",	ListCar.class);
		typedQuery.setParameter("selectedModel",	model);
		List<ListCar>	foundItems	=	typedQuery.getResultList();
		em.close();
		return	foundItems;
	}

	public List<ListCar> searchForCarByBrand(String brand) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar>	typedQuery	=	em.createQuery("select	ch	from	ListCar 	ch	where	ch.brand	=	:selectedBrand",	ListCar.class);
		typedQuery.setParameter("selectedBrand",	brand);
		List<ListCar>	foundItems	=	typedQuery.getResultList();
		em.close();	
		return	foundItems;
	}

	public void updateCar(ListCar toEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();	
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	public void cleanUp() {
		emfactory.close();
		
	}

	
	public List<ListCar> showAllCars()  {
		
		
		EntityManager	em	=	emfactory.createEntityManager();
		List<ListCar>	allCars	=	em.createQuery("SELECT	i	FROM	ListCar	i").getResultList();
		if(allCars.isEmpty()){
			//if there's nothing in the list, redirect the user to the index to add an item
			ListCar c = new ListCar();
			c.setId(0);
			c.setBrand("vazio");
			c.setModel("vazio");
			c.setYear("vazio");
			c.setEngine("vazio");
			List<ListCar> l = new ArrayList<ListCar>();
			l.add(c);
			return l;
		}
		return	allCars;
		}

	public ListCar searchForCarById(int idToEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		ListCar	found	=	em.find(ListCar.class,	idToEdit);
		em.close();
		return	found;
	}



}
