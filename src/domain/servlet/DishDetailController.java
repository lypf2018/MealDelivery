package domain.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.Dish;
import domain.dao.DishDao;

/**
 * Servlet implementation class DishDetailController
 */
@WebServlet("/DishDetailController")
public class DishDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int id = Integer.parseInt(request.getParameter("id"));
		DishDao dishDetailDao = new DishDao();
		List<Dish> list = new ArrayList<Dish>();
		list = dishDetailDao.selectDish(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("list", list);
		request.getRequestDispatcher("dishdetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
