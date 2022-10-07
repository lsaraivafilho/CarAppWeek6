package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/addCarServlet")
public class addCarServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCarServlet() {
        super();       // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String year = request.getParameter("year");	
		String engine = request.getParameter("engine");	
		
		
		ListCar toAdd = new ListCar(brand, model,year, engine );
		CarHelper ch = new CarHelper();
		
		ch.insertCar(toAdd);	
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
		
	}

}
