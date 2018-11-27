package domain.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.Category;
import domain.bean.Dish;
import domain.dao.CategoryDao;
import domain.dao.DishDao;

/**
 * Servlet implementation class AdSelectDishController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CategoryDao categoryDao = new CategoryDao();
		List<Category> categories = categoryDao.selectCategory();
		//categories = categoryDao.selectCategory();
		request.setAttribute("categoryList", categories);
		
		
		DishDao dishDao = new DishDao();
		List<Dish> dishes = dishDao.selectDish(0);
		//dishes = dishDao.selectDish();
		request.setAttribute("dishList", dishes);
		request.getRequestDispatcher("/menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
