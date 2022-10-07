package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClientDetails;

/**
 * Servlet implementation class ViewAllClientsServlet
 */
@WebServlet("/viewAllClientsServlet")
public class ViewAllClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllClientsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try {
		ClientDetailsHelper slh = new ClientDetailsHelper();
		List<ClientDetails> abc = slh.getClients();
		request.setAttribute("allClients", abc);
		if(abc.isEmpty()){
		request.setAttribute("allClients", " ");
		}
		getServletContext().getRequestDispatcher("/car=by-user.jsp").forward(request, response);
		response.getWriter().append("Served a" + "t: ").append(request.getContextPath());
    	}
    	 catch(Exception e){
    	        e.printStackTrace();
    	    }
    	    finally
    	    {
    	        
    	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
