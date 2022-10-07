package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class editCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CarHelper ch = new CarHelper();
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String engine = request.getParameter("engine");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListCar itemToUpdate = ch.searchForCarById(tempId);
		itemToUpdate.setBrand(brand);
		itemToUpdate.setModel(model);
		itemToUpdate.setYear(year);
		itemToUpdate.setEngine(engine);
		ch.updateCar(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}
