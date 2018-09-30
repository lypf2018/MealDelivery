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

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String submitType = request.getParameter("submit");
		
		Customer customerToBeValidate = new Customer(email, password);
		Customer customer = customerDao.validateCustomer(customerToBeValidate);

		// future work: 
		// divided into following cases:(or separate login and register controller)
		// 1) login :
		//     (1)email not exists: data not found; validateEmail()
		//     (2)email exists, but password is wrong: back to login.jsp and showing password wrong
		//            call validateEmail() first, then validate password
		//     (3)pass the validation: welcome
		// 2) register :
		//     (1)email exists: back to login.jsp and showing please try login or forget password
		//     (2)email not exists: data not found
		if(submitType.equals("login") && customer != null && customer.getFirstName() != null && customer.getLastName() != null){
//			Gary
			HttpSession session=request.getSession();
			session.setAttribute("cid", customer.getId());
			session.setAttribute("email", customer.getEmail());
			session.setAttribute("fName", customer.getFirstName());
			session.setAttribute("lName", customer.getLastName());
			session.setAttribute("passwd", customer.getPassword());
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			
//			hb
//			HttpSession session=request.getSession();
//			session.setAttribute("email", customer.getEmail());
//			session.setAttribute("fName", customer.getFirstName());
//			session.setAttribute("lName", customer.getLastName());
//			session.setAttribute("passwd", customer.getPassword());
//			request.getRequestDispatcher("ProfileController").forward(request, response);

//			yzc
//			request.setAttribute("message", "Hello " + customer.getFirstName() + " " + customer.getLastName());
//			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else if (submitType.equals("register") && customerToBeValidate.getEmail() != null) {//if the email exists, what to do
			customer = customerToBeValidate;
			customer.setFirstName(request.getParameter("firstname"));
			customer.setLastName(request.getParameter("lastname"));
			customer.setStreet(request.getParameter("street"));
			customer.setCity(request.getParameter("city"));
			customer.setState(request.getParameter("state"));
			customer.setZip(request.getParameter("zip"));
			customer.setPhone(request.getParameter("phone"));
			customerDao.register(customer);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
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
