package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue
	private int id;
	private String clientName;
	public Client() {
	super();
	// TODO Auto-generated constructor stub
	}
	public Client(int id, String clientName) {
	super();
	this.id = id;
	this.clientName = clientName;
	}
	public Client(String clientName) {
	super();
	this.clientName = clientName;
	
	}
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getClientName() {
	return clientName;
	}
	public void setClientName(String clientName) {
	this.clientName = clientName;
	}
	@Override
	public String toString() {
	return "Client [id=" + id + ", ClientName=" +
	clientName + "]";
	}
	}