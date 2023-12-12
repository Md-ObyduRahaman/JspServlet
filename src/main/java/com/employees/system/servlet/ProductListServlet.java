package com.employees.system.servlet;

import com.employees.system.dao.ProductDao;
import com.employees.system.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;

	
	public void init() {
		productDao = new ProductDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		HttpSession session=request.getSession();
		Long user_id = (Long) session.getAttribute("userId");

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				//insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response,user_id);
				break;
			case "/edit":
				showEditForm(request, response,user_id);
				break;
			case "/update":
				updateUser(request, response,user_id);
				break;
			default:
				listUser(request, response,user_id);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response,Long user_id)
			throws SQLException, IOException, ServletException {

		List<Product> productList = productDao.getAllUser(user_id);
		request.setAttribute("productList", productList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showProduct.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response,Long user_id)
			throws SQLException, ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		Product existingUser = productDao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
		request.setAttribute("product", existingUser);
		dispatcher.forward(request, response);

	}



	private void updateUser(HttpServletRequest request, HttpServletResponse resp,Long user_id)
			throws SQLException, IOException, ServletException {
		Long id = Long.valueOf(request.getParameter("id"));
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		Integer price = Integer.valueOf(request.getParameter("price"));
		Integer quantity = Integer.valueOf(request.getParameter("quantity"));


		Product product = new Product(id,productName,description,price,quantity,user_id);
		Boolean flag= productDao.updateUser(product);
		if(flag){
			request.setAttribute("flag", "saved");
			request.setAttribute("message", "Product saved successfully!");
			// Forward the request to the login page to display the error message
			request.getRequestDispatcher("addProduct.jsp").forward(request, resp);
		}
		else {
			request.setAttribute("flag", "notsaved");
			request.setAttribute("message", "Product Not saved!");
			// Forward the request to the login page to display the error message
			request.getRequestDispatcher("addProduct.jsp").forward(request, resp);
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response,Long user_id)
			throws SQLException, IOException, ServletException {
		Long id = Long.valueOf(request.getParameter("id"));
		productDao.deleteUser(id);
		listUser(request,response,user_id);
	}
}
