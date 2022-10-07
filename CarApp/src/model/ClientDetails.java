package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="client_details")
public class ClientDetails {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="LISTNAME")
	private String listName;
	@Column(name="TRIPDATE")
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="CLIENT_ID")
	private Client client;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListCar> listOfCars;	
	
	

	public ClientDetails(int id, String listName, LocalDate tripDate, Client client, List<ListCar> listOfCars) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.client = client;
		this.listOfCars = listOfCars;
	}

	public ClientDetails(String listName, LocalDate tripDate, Client client, List<ListCar> listOfCars) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.client = client;
		this.listOfCars = listOfCars;
	}


	public ClientDetails(String listName, LocalDate tripDate, Client client) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.client = client;
	}

	public ClientDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientName() {
		return listName;
	}

	public void setClientName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ListCar> getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(List<ListCar> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "ClientDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", client=" + client
				+ ", listOfCars=" + listOfCars + "]";
	}

				

	

}
