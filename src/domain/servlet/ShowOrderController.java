package domain.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.Order;
import domain.dao.AdminOrderDao;

/**
 * Servlet implementation class showOrder
 */
@WebServlet("/admin/ShowOrder")
public class ShowOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the id value of query string
		String id = request.getParameter("id");
//		String status = request.getParameter("status");
		AdminOrderDao orderDao = new AdminOrderDao();
		if(id.equals("all")) {
			ArrayList<Order> list = orderDao.displayOrder();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/admin/adminShowOrder.jsp").forward(request, response);
		}
		else {
			Order order = orderDao.getOrder(id);
			request.setAttribute("id", id);
			request.setAttribute("order", order);
//			request.setAttribute("status", status);
			request.getRequestDispatcher("/admin/getOrderDetail.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath() + "/admin/getOrderDetail.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminOrderDao orderDao = new AdminOrderDao();
		String status = request.getParameter("status");
		String id = (String)request.getAttribute("orderId");
		System.out.println(id);
		//orderDao.updateStatus();
	}
	
//	public static void main(Stirng[] args) {
//		showOrder s = new showOrder();
//		s.doGet(request, response);
//	}

}
