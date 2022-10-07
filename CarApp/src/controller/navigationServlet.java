package controller;
import model.ListCar;

import controller.CarHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		CarHelper dao = new CarHelper();
		String act = request.getParameter("doThisToItem");
		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllCarsServlet";
		if (act.equals("delete")) {
			try {

			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListCar itemToDelete = dao.searchForCarById(tempId);
			dao.deleteCar(itemToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
				} 
			
		}  else if (act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListCar itemToEdit = dao.searchForCarById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			path = "/edit-car.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
				}
			}
 else if (act.equals("add")) {
		path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
		}

	}


