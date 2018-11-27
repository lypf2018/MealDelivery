package domain.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import domain.bean.Dish;
import domain.bean.Category;
import domain.dao.AdminDishDao;
import domain.dao.CategoryDao;


/**
 * Servlet implementation class AdAddDishController
 */
@WebServlet({ "/DishMngController"})
public class DishMngController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "image/";
	
	//configuration for upload
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishMngController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String url = request.getRequestURI();
//		String[] word = url.split("\\/");
		if(request.getParameter("type").equals("add")) {
			showCategoryAdd(request,response);
		} else if(request.getParameter("type").equals("edit")) {
			showCategoryEdit(request,response);
		} 
		else if(request.getParameter("type").equals("menu")) {
			showDish(request,response);
		} 
			else if(request.getParameter("type").equals("delete")) {
			deleteDish(request,response);
		} else if(request.getParameter("type").equals("sortByPrice")) {
			sortBy(request,response, "price");
		} else if(request.getParameter("type").equals("sortByID")) {
			sortBy(request,response, "id");
		} else if(request.getParameter("type").equals("sortByName")) {
			sortBy(request,response, "name");
		} else if(request.getParameter("type").equals("sortByCateory")) {
			sortBy(request,response, "category");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("request="+request.getRequestURI());
//		String url = request.getRequestURI();
//		String[] word = url.split("\\/");
		if(request.getParameter("type").equals("add")) {
			addDish(request,response);
		} else if(request.getParameter("type").equals("edit")) {
			editDish(request,response);
		} else if(request.getParameter("type").equals("addPic")) {
			addPicture(request,response);
		} else if(request.getParameter("type").equals("editPic")) {
			editPicture(request,response);
		}
	}
	
	public void showCategoryAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDao();
		List<Category> cate_list  = categoryDao.selectCategory();
		request.setAttribute("category", cate_list);
		request.getRequestDispatcher("/admin/addDish.jsp").forward(request, response);
	}
	
	public void showCategoryEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AdminDishDao adminDish = new AdminDishDao();
		List<Dish> list = adminDish.selectDish(id);
		Dish dish = list.get(0);
		
		CategoryDao categoryDao = new CategoryDao();
		List<Category> cate_list  = categoryDao.selectCategory();
		
		request.setAttribute("list", dish);
		request.setAttribute("category", cate_list);
		request.getRequestDispatcher("/admin/editDish.jsp").forward(request, response);
	}
	
	public void sortBy(HttpServletRequest request, HttpServletResponse response, String name) throws ServletException, IOException {
		AdminDishDao adminDishDao = new AdminDishDao();
		List<Dish> list = new ArrayList<Dish>();
		list = adminDishDao.sort(name);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/selectDish.jsp").forward(request, response);
	}
	
	public void showDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDishDao adminDishDao = new AdminDishDao();
		List<Dish> list = new ArrayList<Dish>();
		list = adminDishDao.selectDish(0);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/selectDish.jsp").forward(request, response);
	}
	
	public void addDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDishDao adminDishDao = new AdminDishDao();
		Dish dish = new Dish();
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    dish.setName(request.getParameter("dishname"));
	    System.out.println("DishName="+dish.getName());
	    dish.setDes(request.getParameter("des"));
	    String a = request.getParameter("price") != null ? request.getParameter("price") : null;
	    double price = a != "" ? Double.parseDouble(a) : 0.0;
	    dish.setPrice(price);
	    String b = request.getParameter("category") != "" ? request.getParameter("category") : null;
	    int DCId = b != null ? Integer.parseInt(b) : 1;
	    dish.setDCId(DCId);
        dish.setPic(request.getParameter("filePath"));
        
	    int result = adminDishDao.insertDish(dish);
		if(result > 0){
			 request.setAttribute("msg", "Successfully add a new dish!");
			 request.getRequestDispatcher("/admin/addDishConfirm.jsp").forward(request, response);
			 
		}else {
			request.setAttribute("msg", "Failed to add a new dish!");
			 request.getRequestDispatcher("/admin/addDishConfirm.jsp").forward(request, response);
		}
	}
	public void editDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDishDao adminDishDao = new AdminDishDao();
		Dish dish = new Dish();
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    dish.setId(Integer.parseInt(request.getParameter("dishid")));
	    dish.setName(request.getParameter("dishname"));
	    dish.setDes(request.getParameter("des"));
	    dish.setPic(request.getParameter("filePath"));
	    String a = request.getParameter("price") != null ? request.getParameter("price") : null;
	    double price = a != null ? Double.parseDouble(a) : 0.0;
	    dish.setPrice(price);
	    String b = request.getParameter("category") != null ? request.getParameter("category") : null;
	    int DCId = b != null ? Integer.parseInt(b) : 1;
	    dish.setDCId(DCId);
		int result = adminDishDao.updateDish(dish);
		if(result != 0){
			request.setAttribute("msg", "Successfully edit a dish!");
			request.getRequestDispatcher("/admin/editDishConfirm.jsp").forward(request, response);
			 
		}else {
			request.setAttribute("msg", "Failed to edit a dish!");
			request.getRequestDispatcher("/admin/editDishConfirm.jsp").forward(request, response);
		}
	}
	public void deleteDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDishDao adminDishDao = new AdminDishDao();
		int dish_id = Integer.parseInt(request.getParameter("id"));
		int result = adminDishDao.deleteDish(dish_id);
		if(result == 1) {
			request.setAttribute("msg", "Successfully delete a dish!");
			request.getRequestDispatcher("/admin/deleteDishConfirm.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Failed to delete a dish!");
			request.getRequestDispatcher("/admin/deleteDishConfirm.jsp").forward(request, response);
		}
	}
	
	public void addPicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDao();
		List<Category> cate_list  = categoryDao.selectCategory();
		request.setAttribute("category", cate_list);
		
		/**
	     * file upload 
	     */
		PrintWriter out = response.getWriter( );
	    // check if it's a multimedia upload 
	    if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must contain enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory(); // 配置上传参数
        factory.setSizeThreshold(MEMORY_THRESHOLD); // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setRepository(new File(System.getProperty("java.io.tmpdir"))); // 设置临时存储目录
        ServletFileUpload upload = new ServletFileUpload(factory); // 创建解析类的实例
        upload.setFileSizeMax(MAX_FILE_SIZE); // 设置最大文件上传值
        upload.setSizeMax(MAX_REQUEST_SIZE); // 设置最大请求值 (包含文件和表单数据)
        upload.setHeaderEncoding("UTF-8"); // 中文处理
        
        // 构造临时路径来存储上传的文件, 这个路径相对当前应用的目录
//        String uploadPath = request.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY;
        String uploadPath = "/Users/dailu/eclipse-workspace/MealDelivery/WebContent/" + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath); // 如果目录不存在则创建
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        String filePath = null;
        String fileName = null;
        
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
//                        fileName = new File(item.getName()).getName();
                    	fileName = System.currentTimeMillis()+".jpg";
                        filePath = uploadPath + fileName;
                        File storeFile = new File(filePath);
                        System.out.println("dish_path= "+storeFile); // 在控制台输出文件的上传路径
                        item.write(storeFile); // 保存文件到硬盘
                        String path = UPLOAD_DIRECTORY+fileName;
                        request.setAttribute("filePath", path);
                        request.setAttribute("msg", "Successfully upload picture: "+ fileName);
                        out.write("<script type='text/javascript'> alert('Successfully upload picture') </script>");
                        request.getRequestDispatcher("/admin/addDish.jsp").forward(request, response);
//                        response.sendRedirect("/admin/AdAddDishController?filename="+ path); 
                    }
                }
            }
        } catch (Exception e) {
//            request.setAttribute("msg_pic", "Picture_Upload_Error " + e.getMessage());
        	e.printStackTrace();
        	request.setAttribute("msg", "Failed to upload picture "+ fileName);
        	request.getRequestDispatcher("/admin/addDish.jsp").forward(request, response);
        }
	}
	public void editPicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDao();
		List<Category> cate_list  = categoryDao.selectCategory();
		request.setAttribute("category", cate_list);
		
		AdminDishDao adminDishDao = new AdminDishDao();
		int id = Integer.parseInt(request.getParameter("id"));
		Dish dish = adminDishDao.selectDish(id).get(0);
		
		
		/**
	     * file upload 
	     */
		PrintWriter out = response.getWriter( );
	    // check if it's a multimedia upload 
	    if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must contain enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory(); // 配置上传参数
        factory.setSizeThreshold(MEMORY_THRESHOLD); // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setRepository(new File(System.getProperty("java.io.tmpdir"))); // 设置临时存储目录
        ServletFileUpload upload = new ServletFileUpload(factory); // 创建解析类的实例
        upload.setFileSizeMax(MAX_FILE_SIZE); // 设置最大文件上传值
        upload.setSizeMax(MAX_REQUEST_SIZE); // 设置最大请求值 (包含文件和表单数据)
        upload.setHeaderEncoding("UTF-8"); // 中文处理
        
        // 构造临时路径来存储上传的文件, 这个路径相对当前应用的目录
//        String uploadPath = request.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY;
        String uploadPath = "/Users/dailu/eclipse-workspace/MealDelivery/WebContent/" + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath); // 如果目录不存在则创建
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        String filePath = null;
        String fileName = null;
        
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
//                        fileName = new File(item.getName()).getName();
                    	fileName = System.currentTimeMillis()+".jpg";
                        filePath = uploadPath + fileName;
                        File storeFile = new File(filePath);
                        System.out.println("dish_path= "+storeFile); // 在控制台输出文件的上传路径
                        item.write(storeFile); // 保存文件到硬盘
                        String path = UPLOAD_DIRECTORY + fileName;
                        request.setAttribute("filePath", path);
                        request.setAttribute("list", dish);
                        request.setAttribute("msg","Successfully upload picture: " + fileName);
                        out.write("<script type='text/javascript'> alert('Successfully upload picture') </script>");
                        request.getRequestDispatcher("/admin/editDish.jsp").forward(request, response);
//                        response.sendRedirect("/admin/AdAddDishController?filename="+ path); 
                    }
                }
            }
        } catch (Exception e) {
//            request.setAttribute("msg_pic", "Picture_Upload_Error " + e.getMessage());
        	e.printStackTrace();
        	out.write("<script type='text/javascript'> alert('Failed to upload picture') </script>");
            request.getRequestDispatcher("/admin/editDish.jsp").forward(request, response);
        }
	}

}
