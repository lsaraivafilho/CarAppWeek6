package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.ClientDetails;
import model.ListCar;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,	HttpServletResponse response) throws ServletException,	IOException {
    		// TODO Auto-generated method stub
    		CarHelper lih = new CarHelper();
    		String listName = request.getParameter("listName");
    		System.out.println("List Name: "+ listName);
    		String month = request.getParameter("month");
    		String day = request.getParameter("day");
    		String year = request.getParameter("year");
    		String shopperName =
    		request.getParameter("shopperName");
    		LocalDate ld;
    		try {
    		ld = LocalDate.of(Integer.parseInt(year),
    		Integer.parseInt(month), Integer.parseInt(day));
    		}catch(NumberFormatException ex) {
    		ld = LocalDate.now();
    		}
    		String[] selectedItems =
    		request.getParameterValues("allItemsToAdd");
    		List<ListCar> selectedCarsInList = new
    		ArrayList<ListCar>();
    		//make sure something was selected – otherwise we get a null 		pointer exception
    		if (selectedItems != null && selectedItems.length > 0)
    		{
    		for(int i = 0; i<selectedItems.length; i++) {
    		System.out.println(selectedItems[i]);
    		ListCar c =
    		lih.searchForCarById(Integer.parseInt(selectedItems[i]));
    		selectedCarsInList.add(c);
    		}
    		}
    		Client client = new Client(shopperName);
    		ClientDetails sld = new ClientDetails(listName, ld, client);
    		sld.setListOfCars(selectedCarsInList);
    		ClientDetailsHelper slh = new ClientDetailsHelper();
    		slh.insertNewClientDetails(sld);
    		System.out.println("Success!");
    		System.out.println(sld.toString());
    		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
