import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ClientDetailsHelper;
import controller.ClientHelper;
import model.Client;
import model.ClientDetails;
import model.ListCar;

public class ClientTester {

	public ClientTester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Client cameron = new Client("Cameron");
		ClientDetailsHelper ldh = new ClientDetailsHelper();
		ListCar shampoo = new ListCar("Target", "Shampoo","Target", "Shampoo");
		ListCar brush = new ListCar("Target", "Brush","Target", "Shampoo");
		List<ListCar> cameronsItems = new	ArrayList<ListCar>();
		cameronsItems.add(shampoo);
		cameronsItems.add(brush);
		ClientDetails cameronsList = new ClientDetails("Cameron's	ShoppingList", LocalDate.now(), cameron);
		cameronsList.setListOfCars(cameronsItems);
		ldh.insertNewClientDetails(cameronsList);
		List<ClientDetails> allClients = ldh.getClients();
		for(ClientDetails a: allClients) {
		System.out.println(a.toString());
		}
		}
}
