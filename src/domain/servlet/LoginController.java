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
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao customerDao = new CustomerDao();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String submitType = request.getParameter("submit");
		
		Customer customer = new Customer(username, password);
		customer = customerDao.validateCustomer(customer);

		if(submitType.equals("login") && customer != null && customer.getFirstName() != null && customer.getLastName() != null){
			request.setAttribute("message", "Hello " + customer.getFirstName() + " " + customer.getLastName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(submitType.equals("register")){
//			customer.setName(request.getParameter("name"));
//			customer.setUsername(request.getParameter("username"));
//			customer.setPassword(request.getParameter("password"));
//			customerDao.register(customer);
//			request.setAttribute("successMessage", "Registration done, please login!");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
//			request.setAttribute("message", "Data Not Found! Please register!");
//			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
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
