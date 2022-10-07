package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClientDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			IOException, NumberFormatException {
			// TODO Auto-generated method stub
			ClientDetailsHelper dao = new ClientDetailsHelper();
			String act = request.getParameter("doThisToList");
			if (act == null) {
	
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			} else if (act.equals("delete")) {
			try {
			Integer tempId =
			Integer.parseInt(request.getParameter("id"));
			ClientDetails listToDelete =dao.searchForClientDetailsById(tempId);
			dao.deleteClient(listToDelete);
			} catch (NumberFormatException e) {
			System.out.println("Forgot to click a button");
			} finally {
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
			} else if (act.equals("edit")) {
				try {
					
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					ClientDetails listToEdit = dao.searchForClientDetailsById(tempId);
					request.setAttribute("listToEdit", listToEdit);
					request.setAttribute("month",
					listToEdit.getTripDate().getMonthValue());
					request.setAttribute("date",
					listToEdit.getTripDate().getDayOfMonth());
					request.setAttribute("year",
					listToEdit.getTripDate().getYear());
					CarHelper daoForItems = new CarHelper();
					request.setAttribute("allCars", daoForItems.showAllCars());
					if(daoForItems.showAllCars().isEmpty()){
					request.setAttribute("allCars", " ");
					}
					getServletContext().getRequestDispatcher("/editlist.jsp").forward(request, response);
					} catch (NumberFormatException e) {
					getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
			} else if (act.equals("add")) {
			
			getServletContext().getRequestDispatcher("/newlist.html").forward(request, response);
			}
			}

}
