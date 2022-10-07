import java.time.LocalDate;
import java.util.List;

import controller.ClientDetailsHelper;
import controller.ClientHelper;
import model.Client;
import model.ClientDetails;

public class ClientDetailsTester {

	public ClientDetailsTester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Client cameron = new Client("Cameron");
		ClientHelper sh = new ClientHelper();
		sh.insertClient(cameron);
		ClientDetailsHelper ldh = new ClientDetailsHelper();
		
		ClientDetails cameronList = new ClientDetails("Cameron's List",	LocalDate.now(), cameron);
		ldh.insertNewClientDetails(cameronList);
		List<ClientDetails> allClients = ldh.getClients();
		for (ClientDetails a : allClients) {
		System.out.println(a.toString());
		}

	}

}
