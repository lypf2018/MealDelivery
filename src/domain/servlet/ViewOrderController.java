package domain.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.bean.Customer;
import domain.bean.Order;
import domain.bean.OrderItem;
import domain.dao.CustomerDao;
import domain.dao.OrderDao;
import domain.dao.OrderItemDao;

/**
 * Servlet implementation class ViewOrderController
 */
@WebServlet("/ViewOrderController")
public class ViewOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderController() {
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
			 customer = customerDao.validateCustomer(customer); 
			 if(request.getParameter("orderid")==null) {
				 OrderDao orderDao = new OrderDao();
				 ArrayList<Order> orderList = orderDao.displayOrder(customer.getId());
				 request.setAttribute("list", orderList);
				 request.getRequestDispatcher("/vieworder.jsp").forward(request, response);
			 }
			 else {
				 OrderItemDao orderitemdao = new OrderItemDao();
				 ArrayList<OrderItem> list = orderitemdao.getOrderDishes(Integer.parseInt(request.getParameter("orderid")));
				 request.setAttribute("list", list);
				 request.getRequestDispatcher("/vieworderdetails.jsp").forward(request, response);
			 }

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
