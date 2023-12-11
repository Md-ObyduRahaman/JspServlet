package com.employees.system.servlet;

import com.employees.system.dao.ProductDao;
import com.employees.system.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/addProductServlet")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductDao productDao;

    public void init() {
        productDao = new ProductDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session=request.getSession();
        Long user_id = (Long) session.getAttribute("userId");

        Product product=new Product(productName,description,price,quantity,user_id);

        Boolean flag= productDao.saveProduct(product);
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
}
