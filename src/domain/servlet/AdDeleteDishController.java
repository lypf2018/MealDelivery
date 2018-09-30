package domain.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bean.Dish;
import domain.dao.AdminDishDao;

/**
 * Servlet implementation class AdDeleteDishController
 */
@WebServlet({ "/admin/AdDeleteDishController"})
public class AdDeleteDishController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdDeleteDishController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminDishDao adminDishDao = new AdminDishDao();
		int dish_id = Integer.parseInt(request.getParameter("id"));
		int result = adminDishDao.deleteDish(dish_id);
		if(result == 1) {
			request.setAttribute("msg", "Successfully delete a dish!");
			request.getRequestDispatcher("deleteDishConfirm.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Failed to delete a dish!");
			request.getRequestDispatcher("deleteDishConfirm.jsp").forward(request, response);
		}
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
