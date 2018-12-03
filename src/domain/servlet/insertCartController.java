package domain.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.bean.CartItem;
import domain.dao.CartItemDao;

/**
 * Servlet implementation class insertCartController
 */
@WebServlet("/insertCartController")
public class insertCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		int cid = (int) session.getAttribute("cid");
		CartItemDao cartItemDao = new CartItemDao();
		String did = request.getParameter("did");
		String q = request.getParameter("quantity");
		int quantity = Integer.valueOf(q);
		CartItem item = cartItemDao.checkExist(cid, did);
		if (item != null) {
			if (item.getQuantity() + quantity == 0) {
				cartItemDao.deleteItem(cid, did);
			} else {
				cartItemDao.updateItem(cid, did, item.getQuantity() + quantity);
			}
		} else {
			cartItemDao.insertCart(cid, did, quantity);
		}
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
