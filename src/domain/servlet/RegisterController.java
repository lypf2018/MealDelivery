package domain.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.Customer;
import domain.dao.CustomerDao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao customerDao = new CustomerDao();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		String submitType = request.getParameter("submit");
		
		Customer customerToBeInsert = new Customer(email, password);

		if (customerDao.customerEmailExist(customerToBeInsert)) {
			request.setAttribute("message", "Email exist, please choose another email or login directly with that user name!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else {
			customerToBeInsert.setFirstName(request.getParameter("firstname"));
			customerToBeInsert.setLastName(request.getParameter("lastname"));
			customerToBeInsert.setStreet(request.getParameter("street"));
			customerToBeInsert.setCity(request.getParameter("city"));
			customerToBeInsert.setState(request.getParameter("state"));
			customerToBeInsert.setZip(request.getParameter("zip"));
			customerToBeInsert.setPhone(request.getParameter("phone"));
			boolean inserted = customerDao.insertCustomer(customerToBeInsert);
			if(inserted) {
				request.setAttribute("successMessage", "Registration done, please login!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Please insert email!");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
