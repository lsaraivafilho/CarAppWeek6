package controller;
import model.Client;
import model.ClientDetails;
import model.ListCar;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditClientDetailsServlet
 */
@WebServlet("/editClientDetailsServlet")
public class EditClientDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClientDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,	HttpServletResponse response) throws ServletException,	IOException {
			// TODO Auto-generated method stub
			ClientDetailsHelper dao = new ClientDetailsHelper();
			
			CarHelper lih = new CarHelper();
			ClientHelper sh = new ClientHelper();
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ClientDetails listToUpdate = dao.searchForClientDetailsById(tempId);
			String newListName = request.getParameter("listName");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String year = request.getParameter("year");
			String clientName = request.getParameter("clientName");			
			Client newClient = sh.findClient(clientName);
			LocalDate ld;
			try {
			ld = LocalDate.of(Integer.parseInt(year),
			Integer.parseInt(month), Integer.parseInt(day));
			} catch (NumberFormatException ex) {
			ld = LocalDate.now();
			}
			try {
			//items are selected in list to add
			String[] selectedItems =
			request.getParameterValues("allCarsToAdd");
			List<ListCar> selectedItemsInList = new ArrayList<ListCar>();
			for (int i = 0; i < selectedItems.length; i++) {
			System.out.println(selectedItems[i]);
			ListCar c =
			lih.searchForCarById(Integer.parseInt(selectedItems[i]));
			selectedItemsInList.add(c);
			}
			listToUpdate.setListOfCars(selectedItemsInList);
			
			} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<ListCar> selectedItemsInList = new
			ArrayList<ListCar>();
			listToUpdate.setListOfCars(selectedItemsInList);
			}
			listToUpdate.setClientName(newListName);
			listToUpdate.setTripDate(ld);
			listToUpdate.setClient(newClient);
			dao.updateList(listToUpdate);
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}

}
