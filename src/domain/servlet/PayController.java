package domain.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.CartItem;
import domain.dao.CartItemDao;
import domain.dao.OrderDao;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/PayController")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// insert order
		String bill = request.getParameter("bill");
		String cid = request.getParameter("cid");
		OrderDao orderDao = new OrderDao();
		int oid = orderDao.saveOrder(cid, bill);
		
		// insert order details
		int CID = Integer.valueOf(cid);
		CartItemDao cartItemDao = new CartItemDao();
		List<CartItem> dish = new LinkedList<>();
		dish = cartItemDao.getCartDishes(CID);
		for (CartItem item : dish) {
			orderDao.saveOrderDetails(oid, item.getId(), item.getQuantity());
		}
		
		// delete cart items
		cartItemDao.deleteAll(CID);
		
		request.getRequestDispatcher("/CartController").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
