package domain.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.bean.Customer;
import domain.dao.CustomerDao;

/**
 * Servlet implementation class ProfileEditController
 */
@WebServlet("/ProfileEditController")
public class ProfileEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         HttpSession session = request.getSession(false);
		 
		 if(session==null || session.getAttribute("email")==null) {
			 request.setAttribute("message", "Please Login first");
			 request.getRequestDispatcher("/errormassage.jsp").forward(request, response);
		 }
		 else {
			 CustomerDao customerDao = new CustomerDao();
			 Customer customer = new Customer(session.getAttribute("email").toString(), session.getAttribute("passwd").toString());
			 customer.setFirstName(request.getParameter("FirstName"));
			 customer.setLastName(request.getParameter("LastName"));
			 customer.setStreet(request.getParameter("Street"));
			 customer.setCity(request.getParameter("City"));
			 customer.setState(request.getParameter("State"));
			 customer.setZip(request.getParameter("ZipCode"));
			 customer.setPhone(request.getParameter("Phone"));
			 customerDao.updateCustomer(customer);
			 request.getRequestDispatcher("/ProfileController").forward(request, response);
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
