package domain.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.Dish;
import domain.bean.Category;
import domain.dao.AdminDishDao;
import domain.dao.CategoryDao;


/**
 * Servlet implementation class AdAddDishController
 */
@WebServlet({ "/admin/AdAddDishController"})
public class AdAddDishController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdAddDishController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryDao categoryDao = new CategoryDao();
		List<Category> cate_list  = categoryDao.selectCategory();
		request.setAttribute("category", cate_list);
		request.getRequestDispatcher("addDish.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminDishDao adminDishDao = new AdminDishDao();
		Dish dish = new Dish();
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    dish.setName(request.getParameter("dishname"));
	    dish.setDes(request.getParameter("des"));
	    String a = request.getParameter("price") != null ? request.getParameter("price") : null;
	    double price = a != null ? Double.parseDouble(a) : 0.0;
	    dish.setPrice(price);
	    String b = request.getParameter("category") != null ? request.getParameter("category") : null;
	    int DCId = b != null ? Integer.parseInt(b) : 1;
	    dish.setDCId(DCId);
        dish.setPic(request.getParameter("picture"));
        
	    int result = adminDishDao.insertDish(dish);
		if(result > 0){
			 request.setAttribute("msg", "Successfully add a new dish!");
			 request.getRequestDispatcher("addDishConfirm.jsp").forward(request, response);
			 
		}else {
			request.setAttribute("msg", "Failed to add a new dish!");
			 request.getRequestDispatcher("addDishConfirm.jsp").forward(request, response);
		}
	}

}
